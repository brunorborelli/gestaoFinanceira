package com.gestao.financas.model;

import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false, length = 50)
    private Tipo tipo;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false, length = 50)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    private Grupo grupo;

    public Lancamento() {
    }

    public Lancamento(Long id, String nome, String descricao, LocalDate data, Tipo tipo, Double valor, Categoria categoria, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
        this.grupo = grupo;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}