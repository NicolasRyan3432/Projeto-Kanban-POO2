
package database;
import modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

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

public class UsuarioDAO {
    public void cadastrar(Usuario user) throws Exception {
        if (user == null) {
            throw new Exception("\n[CADASTRAR] Erro: Dados do usuário estão vazios!!");
        }
        
        Conexao conexao = new Conexao();
        String sql = "{CALL pCadastraUsuario(?, ?, ?, ?)}";

        try(Connection con = conexao.abrirConexao(); 
            CallableStatement cs = con.prepareCall(sql)) {
            
            cs.setString(1, user.getLogin());
            cs.setString(2, user.getSenha());
            cs.setString(3, user.getApelido());
            cs.setInt(4, user.getPermissao());
            cs.executeUpdate(); 
        }
        catch (Exception e) {
            throw new Exception("\n[CADASTRAR] Erro: " + e.getMessage());
        }
    }
    
    public void modificar(Usuario user) throws Exception {
        if(user == null) {
            throw new Exception("\n[MODIFICAR] Usuário inválido!");
        }
        
           
        // Se a senha tiver vazia (null), modo = 0 (não quer modificar)
        int modo = (user.getSenha() == null) ? 0 : 1;
        
        Conexao conexao = new Conexao();
        String sql = "{CALL pModificaUsuario(?, ?, ?, ?, ?, ?)}";
        
        try(Connection con = conexao.abrirConexao();
           CallableStatement cs = con.prepareCall(sql)) {
            
            // Insere as informações nos parâmetros
            cs.setInt(1, modo);
            cs.setInt(2, user.getId());
            cs.setString(3, user.getLogin());
            cs.setString(4, user.getSenha());
            cs.setString(5, user.getApelido());
            cs.setInt(6, user.getPermissao());
            cs.executeUpdate();
        } 
        catch (Exception e) {
            throw new Exception("\n[MODIFICAR] Erro: " + e.getMessage());
        }
 
    }
    
    public ArrayList<Usuario> listar() throws Exception {
        Conexao conexao = new Conexao();
        
        String sql = "{CALL pListaUsuarios()}";
        try (Connection con = conexao.abrirConexao();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            
            ArrayList<Usuario> listaUsuario = new ArrayList<>();
            
            while(rs.next()) {
                Usuario user = new Usuario (
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("nome"),
                        rs.getInt("permissao"),
                        rs.getInt("ativo")
                );
                
                listaUsuario.add(user);
            }
            return listaUsuario;
        } 
        catch (Exception e) {
            throw new Exception("[LISTAR] Erro: " + e.getMessage());
        }
    }
    
    public Usuario buscar(int id) throws Exception {
        
        Conexao conexao = new Conexao();
        String sql = "{CALL pBuscaUsuario(?)}";
        
        try (Connection con = conexao.abrirConexao();
            CallableStatement cs = con.prepareCall(sql)) {
            
            cs.setInt(1, id);
            Usuario user = new Usuario();
            
            try(ResultSet rs = cs.executeQuery()) {
                while(rs.next()) {
                    user = new Usuario (
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("nome"),
                        rs.getInt("permissao"),
                        rs.getInt("ativo")
                    );
            }
                
            return user;
            
            }
            catch(Exception e) {
                throw new Exception("\n[BUSCAR] Erro ao receber as informações do usuário: " + e.getMessage());
            }
        }
        catch(Exception e) {
            throw new Exception("\n[BUSCAR] Erro: " + e.getMessage());
        }
    }
    
    public boolean verificarCadastro(String login) throws Exception {
        Conexao conexao = new Conexao();
        String sql = "{CALL pVerificaCadastro(?)}";
        
        // Como aqui a procedure precisa de parâmetros, a gente tem que
        // dividir em dois try por conta q ele executa sem ter inserido 
        // os parâmetros e ai dá erro
        try(Connection con = conexao.abrirConexao();
            CallableStatement cs = con.prepareCall(sql)) {
            
            cs.setString(1, login);
            try(ResultSet rs = cs.executeQuery()) {
                return rs.next();
            }
        } 
        catch (Exception e) {
            throw new Exception("\n[VERIFICAR CADASTRO] Erro: " + e.getMessage());
        }
    }
    
    public int alterarStatus(int id, int modo) throws Exception {
        if(id < 1) {
            throw new Exception("\n[DESATIVAR] Id inválido!!!");
        }
        
        Conexao conexao = new Conexao();
        String sql = "{CALL pAlteraStatusUsuario(?, ?, ?)}";
       
        
        try(Connection con = conexao.abrirConexao();
            CallableStatement cs = con.prepareCall(sql)) {
            
            cs.setInt(1, id);
            
            // Modo de execução da função
            if(modo == 0) {
                // Desativa
                cs.setInt(2, 0);
            }
            else {
                // Reativa
                cs.setInt(2, 1);
            }
            
            // Fala pro Java que ele vai receber um número inteiro de volta
            cs.registerOutParameter(3, Types.INTEGER);
            
            // Manda executar
            cs.execute();
            
            // Passa o valor que o banco envidou para a variável
            int resultado = cs.getInt(3);
            return resultado;
        }
        catch(Exception e) {
            throw new Exception("\n[DESATIVAR] Erro: " + e.getMessage());
        }
    }
}