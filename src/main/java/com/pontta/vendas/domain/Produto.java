package com.pontta.vendas.domain;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Positive
    private BigDecimal preco;

    //CONSTRUTOR VAZIO PARA USO DO JPA
    protected Produto(){}

    public Produto(String nome, BigDecimal preco){
        this.nome = nome;
        this.preco = preco;
    }

    //GETTER E SETTER
    public Long getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public BigDecimal getPreco(){
        return preco;
    }
    public void setPreco(BigDecimal preco){
        this.preco = preco;
    }

}
