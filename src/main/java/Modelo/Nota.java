package Modelo;
import java.time.LocalDateTime;

public class Nota {
    private int id;
    private int idUsuario; // Id_usuario pra passar direto para o DAO sem ter que passar como parâmetro na função
    private int prioridade;
    private String nome;
    private String nomeAutor;
    private String descricao;
    private String categoria;
    
    // Pra já passar pro banco como DATETIME, sem precisar formatar igual seria se fosse String
    private LocalDateTime data; 
    private LocalDateTime prazo;

    // Construtor vazio para usar sem ter que inserir diretamente (usando os sets)
    public Nota() {}
    
    // Construtor passado na hora de INSERIR os dados, id é AUTOINCREMENT
    public Nota(int id_usuario, int prioridade, String nome, String nomeAutor, String descricao, String categoria, LocalDateTime data, LocalDateTime prazo) {
        this.idUsuario = id_usuario;
        this.prioridade = prioridade;
        this.nome = nome;
        this.nomeAutor = nomeAutor;
        this.descricao = descricao;
        this.categoria = categoria;
        this.data = data;
        this.prazo = prazo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int id_usuario) {
        this.idUsuario = id_usuario;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }
}
