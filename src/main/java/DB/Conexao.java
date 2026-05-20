/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;


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
        catch (Exception e) {
            //Gera o erro e devolve pro usuário
            throw new Exception(e.getMessage());
        }
        
    }
    
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