
package database;
import java.sql.CallableStatement;
import modelo.HistoricoNota;
import modelo.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;


/* 
               ***------------------- MUDANÇA ----------------------***
    Eu criei uma Procedure que entra com os dados da nota na tabela diretamente
    Suas vantagens sobre como tava antes (SELECT/INSERT plano): 

        1. Economia no Tráfego de Rede: 
                O Java que "executa" todo o processo, caso fosse um SELECT mais complexo (usando CTE, loops...) 
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
        CallableStatement ps = null;
        Conexao conexao = new Conexao();

        try {
            // Conexao sem parametros por conta de passarmos direto dentro da função
            con = conexao.abrirConexao();
            
            String sql = "{CALL pAdicionaNota(?, ?, ?, ?, ?)}";
            
            // Prepara para inserir os valores ? pelas variaveis
            ps = con.prepareCall(sql);
            ps.setString(1, nota.getNome());
            ps.setString(2, nota.getDescricao());
            ps.setInt(3, nota.getPrioridade());
            
            if(nota.getPrazo() != null) {
                // Transforma o LocalDateTime para o formato Timestamp do Banco
                ps.setTimestamp(4, java.sql.Timestamp.valueOf(nota.getPrazo()));  
            }
            else {
                // Prazo indefinido, manda um null do tipo Timestamp (já que o null não tem valor)
                ps.setNull(4, java.sql.Types.TIMESTAMP);
            }
            
            ps.setInt(5, nota.getIdUsuario());
            
            // Joga os dados no Banco
            ps.executeUpdate(); 
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        finally {
            // Executa independente se executou o try ou o catch
            conexao.fecharConexao(con, ps, null);
        }
    }
    
    // Listar chamado lá no Main, para puxar os cartões
    public ArrayList<Nota> listar() throws Exception {

        Connection con = null;
        Statement ps = null;
        ResultSet rs = null;
        Conexao conexao = new Conexao();

        try {
            con = conexao.abrirConexao();
            
            // Pega tudo da tabela notas e junta com a tabela usuarios para pegar o nome
            String sql = "SELECT n.*, u.nome AS nome_autor "
                    + "FROM notas n "
                    + "INNER JOIN usuarios u ON n.id_usuario = u.id";
           
            // Cria o statement pra passar o comando pro banco
            ps = con.createStatement();
            // Executa os comandos SQL
            rs = ps.executeQuery(sql);

            ArrayList<Nota> listaNotas = new ArrayList<>();

            // Vai de linha a linha e verifica se tem login igual ao inserido
            while (rs.next()) {
                Nota nota = new Nota();
                nota.setId(rs.getInt("id_nota"));
                nota.setNome(rs.getString("nome"));
                nota.setDescricao(rs.getString("descricao"));
                nota.setCategoria(rs.getString("categoria"));
                nota.setPrioridade(rs.getInt("prioridade"));
                
                // Cria uma variável que vai receber o valor como timestamp do BD
                Timestamp data = rs.getTimestamp("data_criacao");
                if(data != null) {
                    // Converte de volta para LocalDateTime se não for nulo
                    nota.setData(data.toLocalDateTime());
                }
                else {
                    nota.setData(null);
                }
                
                // Mesma coisa aqui
                Timestamp prazo = rs.getTimestamp("prazo");
                if(prazo != null) {
                    // Converte de volta para LocalDateTime se não for nulo
                    nota.setPrazo(prazo.toLocalDateTime());
                }
                else {
                    nota.setPrazo(null); 
                }
                
                nota.setIdUsuario(rs.getInt("id_usuario"));
                nota.setNomeAutor(rs.getString("nome_autor"));
                
                // Adiciona a nota na nossa lista
                listaNotas.add(nota);
            }
            return listaNotas;
        } 
        catch (Exception e) {
            throw new Exception(e.getMessage());
        } 
        finally {
            conexao.fecharConexao(con, ps, rs);
        }
    }
    
    // Listar chamado lá na TelaHistorico
    public ArrayList<HistoricoNota> listarHistorico(int idNota) throws Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexao conexao = new Conexao();

        try {
            con = conexao.abrirConexao();
            
            // Pega só o histórico daquela nota e ordena pela alteração mais nova
            String sql = "SELECT h.*, u.nome AS nome_autor "
                    + "FROM historico_notas h "
                    + "INNER JOIN usuarios u ON h.id_usuario = u.id "
                    + "WHERE id_nota = ? "
                    + "ORDER BY data_alteracao DESC";
           
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, idNota);
            rs = ps.executeQuery();

            ArrayList<HistoricoNota> listaNotas = new ArrayList<>();
            
            // Vai de linha a linha e verifica se tem login igual ao inserido
            while (rs.next()) {
                HistoricoNota nota = new HistoricoNota();
                nota.setIdHistorico(rs.getInt("id_historico"));
                nota.setIdUsuario(rs.getInt("id_usuario"));
                nota.setIdNota(rs.getInt("id_nota"));
  
                // Pega direto pq aqui a data n é vazia
                nota.setDataAlteracao(rs.getTimestamp("data_alteracao").toLocalDateTime());
                
                nota.setNomeAntigo(rs.getString("nome_antigo"));
                nota.setDescricaoAntiga(rs.getString("descricao_antiga"));
                nota.setCategoriaAntiga(rs.getString("categoria_antiga"));
                nota.setCategoriaNova(rs.getString("categoria_nova"));
                nota.setPrioridadeAntiga(rs.getInt("prioridade_antiga"));
                
                
                // O prazo fica assim porque pode ser que esteja indefinido (null)
                Timestamp prazo = rs.getTimestamp("prazo_antigo");
                if(prazo != null) {
                    // Converte de volta para LocalDateTime se não for nulo
                    nota.setPrazoAntigo(prazo.toLocalDateTime());
                }
                else {
                    nota.setPrazoAntigo(null); 
                }
                
                // Pega o nome do autor (tinha esquecido kkk)
                nota.setAutor(rs.getString("nome_autor"));
                
                // Adiciona a nota na nossa lista
                listaNotas.add(nota);
            }
            return listaNotas;
        } 
        catch (Exception e) {
            throw new Exception(e.getMessage());
        } 
        finally {
            conexao.fecharConexao(con, ps, rs);
        }
    }
   
    public void modificar(Nota nota) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        Conexao conexao = new Conexao();
        
        try {
            con = conexao.abrirConexao();
            String sql = "UPDATE notas SET nome = ?, descricao = ?, " 
                       + "prioridade = ?, prazo = ? " 
                       + "WHERE id_nota = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, nota.getNome());
            ps.setString(2, nota.getDescricao());
            ps.setInt(3, nota.getPrioridade());
            
            if(nota.getPrazo() != null) {
                // Transforma o LocalDateTime para o formato Timestamp do Banco
                ps.setTimestamp(4, Timestamp.valueOf(nota.getPrazo()));  
            }
            else {
                // Prazo indefinido, manda um null do tipo Timestamp (já que o null não tem valor)
                ps.setNull(4, java.sql.Types.TIMESTAMP);
            }
            
            ps.setInt(5, nota.getId());
            ps.executeUpdate();
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        finally {
            conexao.fecharConexao(con, ps, null);
        }
    }
    
    public void deletar(int id) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        Conexao conexao = new Conexao();
        
        try {
            con = conexao.abrirConexao();
            
            String sql = "DELETE FROM notas WHERE id_nota = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();  
        } 
        catch(Exception e) {
            throw new Exception(e.getMessage());
        }
        finally {
            conexao.fecharConexao(con, ps, null);
        }
    }
    
    public void mover(int idNota, String novaCategoria) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        Conexao conexao = new Conexao();
        
        try {
            con = conexao.abrirConexao();

            String sql = "UPDATE notas SET categoria = ? WHERE id_nota = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, novaCategoria);
            ps.setInt(2, idNota);
            ps.executeUpdate();
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        finally {
            conexao.fecharConexao(con, ps, null);
        }
    }
    
    public void adicionarHistorico(int id, String categoriaNova) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        Conexao conexao = new Conexao();
        
        try {
            con = conexao.abrirConexao();

            // Ele insere no histórico copiando direto a nota selecionada
            String sql = "INSERT INTO historico_notas "
                       + "(id_usuario, id_nota, nome_antigo, descricao_antiga, categoria_antiga, prioridade_antiga, prazo_antigo, categoria_nova) "
                       + "SELECT id_usuario, id_nota, nome, descricao, categoria, prioridade, prazo, ? "
                       + "FROM notas WHERE id_nota = ?";

            ps = con.prepareStatement(sql);

            // Passa a categoria nova (se for só edição, passa a mesma que já tava)
            ps.setString(1, categoriaNova); 
            // Passa o ID da nota que vai ser copiada
            ps.setInt(2, id);
            ps.executeUpdate();
        } 
        catch (Exception e) {
            throw new Exception("Erro ao adicionar no histórico: " + e.getMessage());
        } 
        finally {
            conexao.fecharConexao(con, ps, null);
        }
    }
    
    public void restaurar(HistoricoNota nota) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        Conexao conexao = new Conexao();
        
        try {
            con = conexao.abrirConexao();
            
            String sql = "UPDATE notas SET nome = ?, descricao = ?, " 
                       + "prioridade = ?, prazo = ?, categoria = ? " 
                       + "WHERE id_nota = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, nota.getNomeAntigo());
            ps.setString(2, nota.getDescricaoAntiga());
            ps.setInt(3, nota.getPrioridadeAntiga());
            
            if(nota.getPrazoAntigo() != null) {
                // Transforma o LocalDateTime para o formato Timestamp do Banco
                ps.setTimestamp(4, Timestamp.valueOf(nota.getPrazoAntigo()));  
            }
            else {
                // Prazo indefinido, manda um null do tipo Timestamp (já que o null não tem valor)
                ps.setNull(4, java.sql.Types.TIMESTAMP);
            }
            ps.setString(5, nota.getCategoriaAntiga());
            
            ps.setInt(6, nota.getIdNota());
            ps.executeUpdate();
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        finally {
            conexao.fecharConexao(con, ps, null);
        }
    }
}
