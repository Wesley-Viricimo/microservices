package org.wesley.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Neste tipo, a geração do valor da chave primária é delegada ao banco de dados
    private Long id;
    private Double valorSolicitado;
    private int prazoPagamento;
    private Boolean aprovada;
    private boolean integrada;
    private String observacao;

    @OneToOne(cascade = CascadeType.PERSIST) //Faz com que ao salvar uma proposta, o usuário seja salvo também
    @JoinColumn(name = "id_usuario") //Deve ser informado o que será salvo na coluna usuario, neste caso será salvo o id, para referenciar a qual usuário a proposta faz referência
    private Usuario usuario;

    public Proposta() {}

    public Proposta(Long id, Double valorSolicitado, int prazoPagamento, Boolean aprovada, boolean integrada, String observacao, Usuario usuario) {
        this.id = id;
        this.valorSolicitado = valorSolicitado;
        this.prazoPagamento = prazoPagamento;
        this.aprovada = aprovada;
        this.integrada = integrada;
        this.observacao = observacao;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(Double valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public int getPrazoPagamento() {
        return prazoPagamento;
    }

    public void setPrazoPagamento(int prazoPagamento) {
        this.prazoPagamento = prazoPagamento;
    }

    public Boolean getAprovada() {
        return aprovada;
    }

    public void setAprovada(Boolean aprovada) {
        this.aprovada = aprovada;
    }

    public boolean isIntegrada() {
        return integrada;
    }

    public void setIntegrada(boolean integrada) {
        this.integrada = integrada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
