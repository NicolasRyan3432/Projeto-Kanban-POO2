
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.SQLException;


public class Conexao {
    public Connection abrirConexao() throws Exception {
        // Importa a biblioteca Properties que lê as info (par chave valor) do arquivo config.properties
        Properties props = new Properties();
        
        // Importa a biblioteca FileInputStream que procura esse arquivo
        try(FileInputStream fs = new FileInputStream("config.properties")) {
            // Carrega as informações
            props.load(fs);
            
            // Carrega as informações nas respectivas variáveis
            String url = props.getProperty("db.url");
            String usuario = props.getProperty("db.user");
            String senha = props.getProperty("db.password");
            
            //Pega a classe Driver dentro de mysql-connector.../com.mysql.cj.jdbc.Driver/
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //retorna a conexão com o url de conexão, o usuário e senha.
            return DriverManager.getConnection(url, usuario, senha);
        }
        // Pega as excessões que talvez acontecerão na hora de conectar no BD
        catch(SQLException e) {
            // O getSQLState retorna um código padrão de banco de dados
            // Códigos que começam com "08" significam falha de comunicação (Servidor desligado)
            if(e.getSQLState() != null && e.getSQLState().startsWith("08")) {
                throw new Exception("O servidor do Banco de Dados está offline.\nVerifique se o servidor está ligado e tente novamente!");
            }
            // Erro de "Access Denied" (Senha ou usuário do banco errados")
            else if(e.getSQLState() != null && e.getSQLState().equals("28000")) {
                throw new Exception("Erro de autenticação: Usuário ou senha do Banco de Dados incorretos!!");
            }
            // Outro erro que possa dar
            else {
                throw new Exception("Falha ao conectar no Banco: " + e.getMessage());
            }
        }
        catch (Exception e) {
            // Captura erro de drivers não encontrados...
            throw new Exception("Erro interno de conexão: " + e.getMessage());
        }
        
    }
    
    // TODO: Deletar esse método após refatorar o DAO da Nota que ainda tem o finally
    public void fecharConexao(Connection con, Statement stmt, ResultSet rs) throws Exception {
        try {
            if(rs != null) {
                rs.close();
            }
            if(stmt != null) {
                stmt.close();
            }
            if(con != null) {
                con.close();
            }
        } 
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}