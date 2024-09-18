package com.gestao.financas.repository;

import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {

    Optional<Meta> findByGrupoIdAndCategoria(Long grupoId, Categoria categoria);

}