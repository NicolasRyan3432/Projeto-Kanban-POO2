
package modelo;

public class Usuario {
    private int id;
    private String login;
    private String apelido;
    private String permissao;
    private String senha;
    
    public Usuario() {};
    
    public Usuario(int id, String login, String apelido, String permissao, String senha) {
        this.id = id;
        this.login = login;
        this.apelido = apelido;
        this.permissao = permissao;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
