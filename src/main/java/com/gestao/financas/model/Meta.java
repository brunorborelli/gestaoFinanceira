package com.gestao.financas.model;

import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;
import jakarta.persistence.*;

@Entity
@Table(name = "meta")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private Tipo tipo;

    @Column(nullable = false)
    private Double valorObjetivo;

    @Column(nullable = false)
    private Double valorAtual;

    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    private Grupo grupo;

    @Column(nullable = false, length = 50)
    private Categoria categoria;

    public Meta() {
    }

    public Meta(Long id, Tipo tipo, Double valorObjetivo, Double valorAtual, Grupo grupo, Categoria categoria) {
        this.id = id;
        this.tipo = tipo;
        this.valorObjetivo = valorObjetivo;
        this.valorAtual = valorAtual;
        this.grupo = grupo;
        this.categoria = categoria ;
    }



    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Double getValorObjetivo() {
        return valorObjetivo;
    }

    public void setValorObjetivo(Double valorObjetivo) {
        this.valorObjetivo = valorObjetivo;
    }

    public Double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}