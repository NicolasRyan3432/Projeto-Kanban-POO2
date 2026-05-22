package Modelo;
import java.time.LocalDateTime;

public class Nota {
    private int id;
    
    // Id_usuario pra passar direto pro dao sem ter que passar como parâmetro na função
    private int id_usuario;
    
    private int prioridade;
    private String titulo;
    private String descricao;
    
    // Pra já passar pro banco como DATETIME, sem precisar formatar igual seria se fosse String
    private LocalDateTime data; 
    private LocalDateTime prazo;

    // Construtor vazio pra passar pro dao
    public Nota() {}
    
    // Construtor passado na hora de INSERIR os dados, id é AUTOINCREMENT
    public Nota(int id_usuario, int prioridade, String titulo, String descricao, LocalDateTime data, LocalDateTime prazo) {
        this.id_usuario = id_usuario;
        this.prioridade = prioridade;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.prazo = prazo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
