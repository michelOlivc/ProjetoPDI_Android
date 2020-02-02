package michel.projetopdi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Filme {
    private Long idFilme;
    private String nome;
    private String genero;
    private Double duracao;
    private Timestamp dtLancamento;
    private BigDecimal valor;
    private String classificacao;

    public Filme() {}

    public Filme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }

    public Timestamp getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Timestamp dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getClassificacao() { return classificacao; }

    public void setClassificacao(String classificacao) { this.classificacao = classificacao; }

    @Override
    public String toString() {
        return "Filme{" +
                "idFilme=" + idFilme +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", duracao=" + duracao +
                ", dtLancamento=" + dtLancamento +
                ", valor=" + valor +
                ", classificacao=" + classificacao +
                '}';
    }
}
