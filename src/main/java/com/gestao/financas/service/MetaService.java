package com.gestao.financas.service;

import com.gestao.financas.dto.MetaDTO;
import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.model.Grupo;
import com.gestao.financas.model.Meta;
import com.gestao.financas.repository.GrupoRepository;
import com.gestao.financas.repository.MetaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    public Optional<Meta> buscarMetaPorGrupoECategoria(Long grupoId, Categoria categoria) {
        return metaRepository.findByGrupoIdAndCategoria(grupoId, categoria);
    }

    @Transactional
    public void atualizarValorMeta(Long metaId, Double valorLancamento, boolean isDespesa) {
        Optional<Meta> metaOpt = metaRepository.findById(metaId);

        if (metaOpt.isPresent()) {
            Meta meta = metaOpt.get();
            Double novoValorAtual = isDespesa ? meta.getValorAtual() - valorLancamento : meta.getValorAtual() + valorLancamento;

            meta.setValorAtual(novoValorAtual);
            metaRepository.save(meta);

            if (novoValorAtual < 0) {
                meta.getGrupo().setSaldoNegativo(true);
            }
        }
    }
    public Optional<Meta> buscarPorId(Long id) {
        return metaRepository.findById(id);
    }

    public List<Meta> listarTodos() {
        return metaRepository.findAll();
    }

    public void deletarMeta(Long id) {
        Meta meta = metaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Meta não encontrada"));
        metaRepository.delete(meta);
    }

    public Meta salvarMeta(MetaDTO metaDTO) {
        Grupo grupo = grupoRepository.findById(metaDTO.getGrupoId())
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));

        Meta meta = new Meta();
        meta.setId(metaDTO.getId());
        meta.setTipo(metaDTO.getTipo());
        meta.setValorObjetivo(metaDTO.getValorObjetivo());
        meta.setValorAtual(metaDTO.getValorAtual());
        meta.setGrupo(grupo);
        meta.setCategoria(metaDTO.getCategoria());

        return metaRepository.save(meta);
    }
}
