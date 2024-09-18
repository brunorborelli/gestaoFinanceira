package com.gestao.financas.dto;

import java.util.Set;

public class GrupoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Boolean isSaldoNegativo;
    private Set<Long> metaIds;

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

    public Boolean getIsSaldoNegativo() {
        return isSaldoNegativo;
    }

    public void setIsSaldoNegativo(Boolean isSaldoNegativo) {
        this.isSaldoNegativo = isSaldoNegativo;
    }

    public Set<Long> getMetaIds() {
        return metaIds;
    }

    public void setMetaIds(Set<Long> metaIds) {
        this.metaIds = metaIds;
    }
}
