
package modelo;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String apelido;
    private int permissao;
    private int ativo;
    
    public Usuario() {};
    
    public Usuario(int id, String login, String senha, String apelido, int permissao, int ativo) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.apelido = apelido;
        this.permissao = permissao;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
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

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
