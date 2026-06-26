
package database;
import java.sql.Connection;

public class TestarConexao {
    public void main(String[] args) {
        Conexao con = new Conexao();
        
        try(Connection c = con.abrirConexao()) {
            System.out.println("Conectado!!!");
        } 
        catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
