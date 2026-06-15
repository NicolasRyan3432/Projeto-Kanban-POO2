
package database;
import modelo.HistoricoNota;
import modelo.Nota;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;


/* 
               ***------------------- MUDANÇA ----------------------***
    Eu criei uma Procedure que entra com os dados da nota na tabela diretamente
    Suas vantagens sobre como tava antes (SELECT/INSERT plano): 

        1. Economia no Tráfego de Rede: 
                O Java que "executa" todo o processo, caso fosse um SELECT mais complexo (usando CTE, loocd...) 
                ele teria que pedir para o banco enviar os dados para ele, 
                ele faria o que teria de ser feito e só assim o JDBC enviaria o resultado para o Banco.

        2. Bloqueio de Permissões: 
                O Java é permitido somente a usar aquela procedure, ou seja,   
                ele não precisa de ter permissões de poder modificar 
                todas as tabelas, e sim de somente chamar aquela procedure
                
        3. Centralização da lógica: 
                Caso fosse adicionado mais uma coluna na tabela de Notas, 
                o unico lugar que será modificado (caso precise) é na procedure chamada, 
                evitando assim de que o programa pare de funcionar
                
        4. Pré-compilação e Cache: 
                Ao criar a procedure, o MYSQL (ou qualquer SGDB usado) já analisa a sintaxe, 
                analisa o plano de execução e guarda tudo isso na memória RAM.   
               ***--------------------------------------------------------***
        */

public class NotaDAO {
    public void criar(Nota nota) throws Exception {
        if (nota == null) {
            throw new Exception("Erro: Dados da nota estão vazios!!");
        }
        
        Connection con = null;
        CallableStatement cs = null;
        Conexao conexao = new Conexao();

        try {
            // Conexao sem parametros por conta de passarmos direto dentro da função
            con = conexao.abrirConexao();
            
            String sql = "{CALL pAdicionaNota(?, ?, ?, ?, ?)}";
            
            // Prepara para inserir os valores ? pelas variaveis
            cs = con.prepareCall(sql);
            cs.setString(1, nota.getNome());
            cs.setString(2, nota.getDescricao());
            cs.setInt(3, nota.getPrioridade());
            
            LocalDateTime prazo = nota.getPrazo();
            Timestamp prazoB = (prazo != null) ? Timestamp.valueOf(prazo) : null;
            
            cs.setTimestamp(4, prazoB);
            cs.setInt(5, nota.getIdUsuario());
            
            // Joga os dados no Banco
            cs.executeUpdate(); 
        }
        catch (Exception e) {
            throw new Exception("\n[CRIAR] Erro: " + e.getMessage());
        }
        finally {
            // Executa independente se executou o try ou o catch
            conexao.fecharConexao(con, cs, null);
        }
    }
    
    // Listar chamado lá no Main, para puxar os cartões
    public ArrayList<Nota> listar() throws Exception {

        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Conexao conexao = new Conexao();

        try {
            con = conexao.abrirConexao();
            
            // Pega tudo da tabela notas e junta com a tabela usuarios para pegar o nome
            String sql = "{CALL pListaNotas()}";
           
            // Cria o statement pra passar o comando pro banco
            cs = con.prepareCall(sql);
            
            // Executa os comandos SQL
            rs = cs.executeQuery(sql);

            ArrayList<Nota> listaNotas = new ArrayList<>();
            
            
            while (rs.next()) {
                /*
                    Ao invés de passar pelos sets, a gente utiliza o construtor com parâmetros,
                    o que deixa muito mais enxuto a função, além de utilizar o operador ternário.
                
                    Operador ternário: a data do banco não tá vazia?
                    Não -> Insere o valor convertido para LocalDateTime e insere
                    na data
                    Sim -> Insere o valor nulo na data
                    
                    Sintaxe: valor = (condição) ? Verdadeiro : Falso
                */
                
                Timestamp dataB = rs.getTimestamp("data_criacao");
                Timestamp prazoB = rs.getTimestamp("prazo");
                
                
                LocalDateTime data = (dataB != null) ? dataB.toLocalDateTime() : null;
                LocalDateTime prazo = (prazoB != null) ? prazoB.toLocalDateTime() : null;
                
                Nota nota = new Nota (
                    rs.getInt("id_nota"),
                    rs.getInt("prioridade"),
                    rs.getString("nome"),
                    rs.getString("nome_autor"),
                    rs.getString("descricao"),
                    rs.getString("categoria"),
                    null,
                    data,
                    prazo     
                );
                
                // Adiciona a nota na nossa lista
                listaNotas.add(nota);
            }
            return listaNotas;
        } 
        catch (Exception e) {
            throw new Exception("\n[LISTAR] Erro: " + e.getMessage());
        } 
        finally {
            conexao.fecharConexao(con, cs, rs);
        }
    }
    
    // Listar chamado lá na TelaHistorico
    public ArrayList<HistoricoNota> listarHistorico(int idNota) throws Exception {

        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Conexao conexao = new Conexao();

        try {
            con = conexao.abrirConexao();
            
            // Pega só o histórico daquela nota e ordena pela alteração mais nova
            String sql = "{CALL pListaHistorico(?)}";
           
            
            cs = con.prepareCall(sql);
            cs.setInt(1, idNota);
            rs = cs.executeQuery();

            ArrayList<HistoricoNota> listaNotas = new ArrayList<>();
            
            // Vai de linha a linha e verifica se tem login igual ao inserido
            while (rs.next()) {
                Timestamp prazoB = rs.getTimestamp("prazo_antigo");
                LocalDateTime prazo = (prazoB != null) ? prazoB.toLocalDateTime() : null;
                
                HistoricoNota nota = new HistoricoNota (
                        rs.getInt("id_historico"),
                        rs.getInt("id_usuario"),
                        rs.getInt("id_nota"),
                        rs.getInt("prioridade_antiga"),
                        rs.getString("nome_antigo"),
                        rs.getString("nome_autor"),
                        rs.getString("descricao_antiga"),
                        rs.getString("categoria_antiga"),
                        rs.getString("categoria_nova"),
                        rs.getTimestamp("data_alteracao").toLocalDateTime(),
                        prazo
                );
 
                listaNotas.add(nota);
            }
            return listaNotas;
        } 
        catch (Exception e) {
            throw new Exception("\n[LISTAR HISTORICO] Erro: " + e.getMessage());
        } 
        finally {
            conexao.fecharConexao(con, cs, rs);
        }
    }
   
    public void modificar(Nota nota) throws Exception {
        Connection con = null;
        CallableStatement cs = null;
        Conexao conexao = new Conexao();
        
        try {
            con = conexao.abrirConexao();
            String sql = "{CALL pModificaNota(?, ?, ?, ?, ?)}";

            cs = con.prepareCall(sql);
            cs.setString(1, nota.getNome());
            cs.setString(2, nota.getDescricao());
            cs.setInt(3, nota.getPrioridade());
            
            LocalDateTime prazo = nota.getPrazo();
            Timestamp prazoB = (prazo != null) ? Timestamp.valueOf(prazo) : null;
          
            cs.setTimestamp(4, prazoB);
            cs.setInt(5, nota.getId());
            cs.executeUpdate();
        }
        catch (Exception e) {
            throw new Exception("\n[MODIFICAR] Erro: " + e.getMessage());
        }
        finally {
            conexao.fecharConexao(con, cs, null);
        }
    }
    
    public void deletar(int id) throws Exception {
        Connection con = null;
        CallableStatement cd = null;
        Conexao conexao = new Conexao();
        
        try {
            con = conexao.abrirConexao();
            
            String sql = "{CALL pDeletaNota(?)}";
            cd = con.prepareCall(sql);
            cd.setInt(1, id);
            cd.executeUpdate();  
        } 
        catch(Exception e) {
            throw new Exception("\n[DELETAR] Erro:" + e.getMessage());
        }
        finally {
            conexao.fecharConexao(con, cd, null);
        }
    }
    
    public void mover(int idNota, String novaCategoria) throws Exception {
        Connection con = null;
        CallableStatement cd = null;
        Conexao conexao = new Conexao();
        
        try {
            con = conexao.abrirConexao();

            String sql = "{CALL pMoveNota(?, ?)}";

            cd = con.prepareCall(sql);
            cd.setInt(1, idNota);
            cd.setString(2, novaCategoria);
            cd.executeUpdate();
        }
        catch (Exception e) {
            throw new Exception("\n[MOVER] Erro: " + e.getMessage());
        }
        finally {
            conexao.fecharConexao(con, cd, null);
        }
    }
    
    public void adicionarHistorico(int id, String categoriaNova) throws Exception {
        Connection con = null;
        CallableStatement cd = null;
        Conexao conexao = new Conexao();
        
        try {
            con = conexao.abrirConexao();

            // Ele insere no histórico copiando direto a nota selecionada
            String sql = "{CALL pAdicionaHistorico(?, ?)}";

            cd = con.prepareCall(sql);

            // Passa a categoria nova (se for só edição, passa a mesma que já tava)
            cd.setString(1, categoriaNova); 
            
            // Passa o ID da nota que vai ser copiada
            cd.setInt(2, id);
            cd.executeUpdate();
        } 
        catch (Exception e) {
            throw new Exception("\n[ADICIONAR HISTORICO] Erro: " + e.getMessage());
        } 
        finally {
            conexao.fecharConexao(con, cd, null);
        }
    }
    
    public void restaurar(HistoricoNota nota) throws Exception {
        Connection con = null;
        CallableStatement cd = null;
        Conexao conexao = new Conexao();
        
        try {
            con = conexao.abrirConexao();
            
            String sql = "{CALL pRestauraNota(?, ?, ?, ?, ?, ?)}";

            cd = con.prepareCall(sql);
            cd.setString(1, nota.getNomeAntigo());
            cd.setString(2, nota.getDescricaoAntiga());
            cd.setInt(3, nota.getPrioridadeAntiga());
            
            LocalDateTime prazo = nota.getPrazoAntigo();
            Timestamp prazoB = (prazo != null) ? Timestamp.valueOf(prazo) : null;
            
            
            cd.setTimestamp(4, prazoB);  
            cd.setString(5, nota.getCategoriaAntiga());
            
            cd.setInt(6, nota.getIdNota());
            cd.executeUpdate();
        }
        catch (Exception e) {
            throw new Exception("\n[RESTAURAR] Erro: " + e.getMessage());
        }
        finally {
            conexao.fecharConexao(con, cd, null);
        }
    }
}
