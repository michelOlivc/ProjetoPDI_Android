package michel.projetopdi.model;

public class Cliente {
    private Long idCliente;
    private Integer idade;
    private Integer inscricao;
    private String endereco;
    private Boolean bloqueado;

    public Cliente() {}

    public Cliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getInscricao() {
        return inscricao;
    }

    public void setInscricao(Integer inscricao) {
        this.inscricao = inscricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", idade=" + idade +
                ", inscricao=" + inscricao +
                ", endereco='" + endereco + '\'' +
                ", bloqueado=" + bloqueado +
                '}';
    }
}
