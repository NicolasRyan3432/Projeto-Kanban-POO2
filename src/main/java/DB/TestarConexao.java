/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;

public class TestarConexao {
    public void main(String[] args) {
        Conexao con = new Conexao();
        
        try {
            Connection c = con.abrirConexao();
            System.out.println("Conectado!!!");
            con.fecharConexao(c, null, null);
            
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
