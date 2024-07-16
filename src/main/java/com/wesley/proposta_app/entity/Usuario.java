package com.wesley.proposta_app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Neste tipo, a geração do valor da chave primária é delegada ao banco de dados
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private Double renda;

    @OneToOne(mappedBy = "usuario") //Informando que o mapeamento foi feito no atributo usuário da entidade proposta
    private Proposta proposta;

    public Usuario() {}
}
