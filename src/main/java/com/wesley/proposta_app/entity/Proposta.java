package com.wesley.proposta_app.entity;

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

    @OneToOne
    @JoinColumn(name = "id_usuario") //Deve ser informado o que será salvo na coluna usuario, neste caso será salvo o id, para referenciar a qual usuário a proposta faz referência
    private Usuario usuario;

    public Proposta() {}
}
