
package DB;

import Modelo.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NotaDAO {
    public void criar(Nota nota) throws Exception {
        if (nota == null) {
            throw new Exception("Erro: Dados da nota estão vazios!!");
        }

        // Conexão com o banco
        Connection con = null;
        // Comando SQL a ser executado
        PreparedStatement ps = null;
        // Conexao com o banco
        Conexao conexao = new Conexao();

        try {
            // Conexao sem parametros por conta de passarmos direto dentro da função
            con = conexao.abrirConexao();
            
            String sql = "INSERT INTO notas (nome, descricao, prioridade, prazo, id_usuario) VALUES (?, ?, ?, ?, ?)";
            
            // Prepara para inserir os valores ? pelas variaveis
            ps = con.prepareStatement(sql);
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
            
            ps.setInt(5, nota.getId_usuario());
            
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
}
