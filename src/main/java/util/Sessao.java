
package util;


public class Sessao {
    
    // Variáveis globais que vão guardar as informações de quem está logado no momento
    // Estático permite que acesse as informações sem ter que instanciar a classe
    public static int idUsuario = -1;
    public static String login = "";
    public static String apelido = "";
    public static int permissao = -1;
    public static int ativo = -1;
    
    // Pra usar no item de Logout lá no Main
    public static void limparSessao() {
        idUsuario = -1;
        login = "";
        apelido = "";
        permissao = -1;
        ativo = -1;
    }
}
