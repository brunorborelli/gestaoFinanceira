package com.gestao.financas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @OneToMany
    @JoinColumn(name = "grupo_id")
    private List<Pessoa> pessoas;
    private Boolean isSaldoNegativo;

    @JsonIgnore
    @OneToMany(mappedBy = "grupo")
    private Set<Meta> metas;


    public Grupo() {
    }


    public Grupo(Long id, String nome, String descricao, Set<Meta> metas) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.metas = metas;
    }


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

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Boolean getSaldoNegativo() {
        return isSaldoNegativo;
    }

    public void setSaldoNegativo(Boolean saldoNegativo) {
        isSaldoNegativo = saldoNegativo;
    }

    public Set<Meta> getMetas() {
        return metas;
    }

    public void setMetas(Set<Meta> metas) {
        this.metas = metas;
    }
}