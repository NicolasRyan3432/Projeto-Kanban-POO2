
package Modelo;

import java.time.LocalDateTime;


public class HistoricoNota {
    // Os nomes das variáveis tão do mesmo jeito que tá no BD
    private int idHistorico;
    private int idUsuario; 
    private int idNota;
    private int prioridadeAntiga;
    private String nomeAntigo;
    private String autor;
    private String descricaoAntiga;
    private String categoriaAntiga;
    private String categoriaNova;
    private LocalDateTime dataAlteracao;
    private LocalDateTime prazoAntigo;
    
    public HistoricoNota() {}
    
    public HistoricoNota(int idHistorico, int idUsuario, int idNota, int prioridadeAntiga, String nomeAntigo, String autor, String descricaoAntiga, String categoriaAntiga, String categoriaNova, LocalDateTime dataAlteracao, LocalDateTime prazoAntigo) {
        this.idHistorico = idHistorico;
        this.idUsuario = idUsuario;
        this.idNota = idNota;
        this.prioridadeAntiga = prioridadeAntiga;
        this.nomeAntigo = nomeAntigo;
        this.autor = autor;
        this.descricaoAntiga = descricaoAntiga;
        this.categoriaAntiga = categoriaAntiga;
        this.categoriaNova = categoriaNova;
        this.dataAlteracao = dataAlteracao;
        this.prazoAntigo = prazoAntigo;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getPrioridadeAntiga() {
        return prioridadeAntiga;
    }

    public void setPrioridadeAntiga(int prioridadeAntiga) {
        this.prioridadeAntiga = prioridadeAntiga;
    }

    public String getNomeAntigo() {
        return nomeAntigo;
    }

    public void setNomeAntigo(String nomeAntigo) {
        this.nomeAntigo = nomeAntigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricaoAntiga() {
        return descricaoAntiga;
    }

    public void setDescricaoAntiga(String descricaoAntiga) {
        this.descricaoAntiga = descricaoAntiga;
    }

    public String getCategoriaAntiga() {
        return categoriaAntiga;
    }

    public void setCategoriaAntiga(String categoriaAntiga) {
        this.categoriaAntiga = categoriaAntiga;
    }

    public String getCategoriaNova() {
        return categoriaNova;
    }

    public void setCategoriaNova(String categoriaNova) {
        this.categoriaNova = categoriaNova;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDateTime getPrazoAntigo() {
        return prazoAntigo;
    }

    public void setPrazoAntigo(LocalDateTime prazoAntigo) {
        this.prazoAntigo = prazoAntigo;
    }
    
    
}
