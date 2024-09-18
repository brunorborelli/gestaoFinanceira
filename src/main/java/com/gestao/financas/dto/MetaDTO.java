package com.gestao.financas.dto;

import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;

public class MetaDTO {

    private Long id;
    private Tipo tipo;
    private Double valorObjetivo;
    private Double valorAtual;
    private Long grupoId;
    private Categoria categoria;

    public MetaDTO() {
    }

    public MetaDTO(Long id, Tipo tipo, Double valorObjetivo, Double valorAtual, Long grupoId, Categoria categoria) {
        this.id = id;
        this.tipo = tipo;
        this.valorObjetivo = valorObjetivo;
        this.valorAtual = valorAtual;
        this.grupoId = grupoId;
        this.categoria = categoria;
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

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
