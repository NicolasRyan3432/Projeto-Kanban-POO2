
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


/** =============================================================================
*   ++========================== MUDANÇA ARQUITETURAL =========================++
*   =============================================================================
* Substituição do SELECT/INSERT tradicional (Raw SQL) por uma Stored Procedure 
* para inserção direta dos dados da nota. 
* 
* Vantagens dessa abordagem:
*   1. Economia no Tráfego de Rede: 
*       O Java que "executa" todo o processo, caso fosse um SELECT mais complexo (usando CTE, loop...) 
*       ele teria que pedir para o banco enviar os dados para ele, 
*       ele faria o que teria de ser feito e só assim o JDBC enviaria o resultado para o Banco.
*
*   2. Bloqueio de Permissões: 
*        O Java é permitido somente a usar aquela procedure, ou seja,   
*        ele não precisa de ter permissões de poder modificar 
*       todas as tabelas, e sim de somente chamar aquela procedure
*                
*   3. Centralização da lógica: 
*       Caso fosse adicionado mais uma coluna na tabela de Notas, 
*       o unico lugar que será modificado (caso precise) é na procedure chamada, 
*       evitando assim de que o programa pare de funcionar
*                
*   4. Pré-compilação e Cache: 
*       Ao criar a procedure, o MYSQL (ou qualquer SGDB usado) já analisa a sintaxe, 
*       analisa o plano de execução e guarda tudo isso na memória RAM.   
*
*   =============================================================================
*   ++==================== REFATORAÇÃO DE CONEXÕES (TRY) ======================++
*   =============================================================================
*
* Substituição do padrão antigo de blocos try-catch-finally (Java 6) pelo 
* moderno TRY-WITH-RESOURCES (Java 7+).
* 
* Como as classes Connection, PreparedStatement, CallableStatement e ResultSet 
* implementam a interface AutoCloseable nativamente, o próprio Java se 
* encarrega de fechar as conexões automaticamente ao fim da execução (ou em 
* caso de erro). Isso evita vazamentos de memória (Connection Leaks) e deixa 
* o código muito mais enxuto, limpo e seguro.
*               
* ++===========================================================================++
*/

public class NotaDAO {
    public void criar(Nota nota) throws Exception {
        if (nota == null) {
            throw new Exception("Erro: Dados da nota estão vazios!!");
        }
        
        Conexao conexao = new Conexao();
        String sql = "{CALL pAdicionaNota(?, ?, ?, ?, ?)}";

        try(Connection con = conexao.abrirConexao();
            CallableStatement cs = con.prepareCall(sql)) {
            
            // Prepara para inserir os valores ? pelas variaveis
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
    }
    
    // Listar chamado lá no Main, para puxar os cartões
    public ArrayList<Nota> listar() throws Exception {

        Conexao conexao = new Conexao();
        String sql = "{CALL pListaNotas()}";

        try(Connection con = conexao.abrirConexao();
            CallableStatement cs = con.prepareCall(sql)) {
            
           try(ResultSet rs = cs.executeQuery(sql)) {
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
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getString("categoria"),
                        rs.getInt("prioridade"),
                        data,
                        rs.getInt("id_usuario"),
                        prazo,     
                        rs.getString("nome_autor")
                    );

                    // Adiciona a nota na nossa lista
                    listaNotas.add(nota);
                }
                return listaNotas;
            
           }
           catch(Exception e) {
               throw new Exception("\n[LISTAR - ResultSet] Erro ao receber dados da nota: " + e.getMessage());
           }
        } 
        catch(Exception e) {
            throw new Exception("\n[LISTAR] Erro: " + e.getMessage());
        } 
    }
    
    // Listar chamado lá na TelaHistorico
    public ArrayList<HistoricoNota> listarHistorico(int idNota) throws Exception {

        Conexao conexao = new Conexao();
        
        // Pega só o histórico daquela nota e ordena pela alteração mais nova
        String sql = "{CALL pListaHistorico(?)}";

        try(Connection con = conexao.abrirConexao();
            CallableStatement cs = con.prepareCall(sql)) {
            
            cs.setInt(1, idNota);
            
            try(ResultSet rs = cs.executeQuery()) {
                
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
            catch(Exception e) {
                throw new Exception("\n[LISTAR HISTÓRICO - ResultSet] Erro ao tentar obter informações do histórico da nota: " + e.getMessage());
            }
        }
        catch (Exception e) {
            throw new Exception("\n[LISTAR HISTORICO] Erro: " + e.getMessage());
        } 
    }
   
    public void modificar(Nota nota) throws Exception {

        Conexao conexao = new Conexao();
        String sql = "{CALL pModificaNota(?, ?, ?, ?, ?)}";
        
        try(Connection con = conexao.abrirConexao();
            CallableStatement cs = con.prepareCall(sql)) {
            
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
    }
    
    public void deletar(int id) throws Exception {
        
        Conexao conexao = new Conexao();
        String sql = "{CALL pDeletaNota(?)}";
        
        try(Connection con = conexao.abrirConexao();
            CallableStatement cd = con.prepareCall(sql)) {
            
            cd.setInt(1, id);
            cd.executeUpdate();  
        } 
        catch(Exception e) {
            throw new Exception("\n[DELETAR] Erro:" + e.getMessage());
        }
    }
    
    public void mover(int idNota, String novaCategoria) throws Exception {
      
        Conexao conexao = new Conexao();
        String sql = "{CALL pMoveNota(?, ?)}";
        
        try(Connection con = conexao.abrirConexao();
            CallableStatement cd = con.prepareCall(sql)) {
            
            cd.setInt(1, idNota);
            cd.setString(2, novaCategoria);
            cd.executeUpdate();
        }
        catch (Exception e) {
            throw new Exception("\n[MOVER] Erro: " + e.getMessage());
        }
    }
    
    public void adicionarHistorico(int id, String categoriaNova) throws Exception {

        Conexao conexao = new Conexao();
        String sql = "{CALL pAdicionaHistorico(?, ?)}";
        
        try(Connection con = conexao.abrirConexao();
            CallableStatement cd = con.prepareCall(sql)) {

            // Passa a categoria nova (se for só edição, passa a mesma que já tava)
            cd.setString(1, categoriaNova); 
            
            // Passa o ID da nota que vai ser copiada
            cd.setInt(2, id);
            cd.executeUpdate();
        } 
        catch (Exception e) {
            throw new Exception("\n[ADICIONAR HISTORICO] Erro: " + e.getMessage());
        } 
    }
    
    public void restaurar(HistoricoNota nota) throws Exception {

        Conexao conexao = new Conexao();
        String sql = "{CALL pRestauraNota(?, ?, ?, ?, ?, ?)}";
        
        try(Connection con = conexao.abrirConexao();
            CallableStatement cd = con.prepareCall(sql)) {
            

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
    }
    
    public int contar(int id) throws Exception {
        Conexao conexao = new Conexao();
        String sql = "{CALL pContaNotas(?, ?)}";
        
        try(Connection con = conexao.abrirConexao();
           CallableStatement cs = con.prepareCall(sql)) {
            
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();
            
            int total = cs.getInt(2);
            return total; 
        }
        catch(Exception e) {
            throw new Exception("\n[CONTAR] Erro: " + e.getMessage());
        }
    }
}
