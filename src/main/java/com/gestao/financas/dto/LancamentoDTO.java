package com.gestao.financas.dto;

import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;
import java.time.LocalDate;

public class LancamentoDTO {

    private Long grupoId;
    private String nome;
    private String descricao;
    private LocalDate data;
    private Tipo tipo;
    private Double valor;
    private Categoria categoria;

    public LancamentoDTO() {
    }

    public LancamentoDTO(Long grupoId, String nome, String descricao, LocalDate data, Tipo tipo, Double valor, Categoria categoria) {
        this.grupoId = grupoId;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
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
}