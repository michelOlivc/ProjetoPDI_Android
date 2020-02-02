package michel.projetopdi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Locacao {
    private Long idLocacao;
    private Cliente cliente;
    private List<Filme> listaFilmes;
    private BigDecimal valorTotal;
    private Timestamp dtDevolucao;
    private Boolean pago;

    public Locacao() {}

    public Locacao(Long idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Long getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(Long idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Timestamp getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(Timestamp dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "idLocacao=" + idLocacao +
                ", listaFilmes=" + listaFilmes +
                ", valorTotal=" + valorTotal +
                ", dtDevolucao=" + dtDevolucao +
                ", pago=" + pago +
                '}';
    }
}
