package com.gestao.financas.service;

import com.gestao.financas.dto.LancamentoDTO;
import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;
import com.gestao.financas.model.Grupo;
import com.gestao.financas.model.Lancamento;
import com.gestao.financas.model.Meta;
import com.gestao.financas.repository.GrupoRepository;
import com.gestao.financas.repository.LancamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private MetaService metaService;

    @Autowired
    private GrupoRepository grupoRepository;

    @Transactional
    public Lancamento criarLancamento(Long grupoId, String nome, String descricao, LocalDate data, Tipo tipo, Double valor, Categoria categoria) {

        Optional<Meta> metaOpt = metaService.buscarMetaPorGrupoECategoria(grupoId, categoria);

        if (metaOpt.isPresent()) {
            Meta meta = metaOpt.get();
            Lancamento lancamento = new Lancamento(null, nome, descricao, data, tipo, valor, categoria, meta.getGrupo());

            lancamentoRepository.save(lancamento);

            boolean isDespesa = tipo == Tipo.DESPESA;
            metaService.atualizarValorMeta(meta.getId(), valor, isDespesa);

            return lancamento;
        } else {
            throw new IllegalStateException("Não há uma meta definida para essa categoria no grupo informado.");
        }
    }

    public Optional<Lancamento> buscarPorId(Long id) {
        return lancamentoRepository.findById(id);
    }

    public List<Lancamento> listarTodos() {
        return lancamentoRepository.findAll();
    }

    public Lancamento atualizarLancamento(Long id, LancamentoDTO lancamentoDTO) {
        Lancamento lancamentoExistente = lancamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lançamento não encontrado"));

        lancamentoExistente.setNome(lancamentoDTO.getNome());
        lancamentoExistente.setDescricao(lancamentoDTO.getDescricao());
        lancamentoExistente.setData(lancamentoDTO.getData());
        lancamentoExistente.setTipo(lancamentoDTO.getTipo());
        lancamentoExistente.setValor(lancamentoDTO.getValor());
        lancamentoExistente.setCategoria(lancamentoDTO.getCategoria());

        Grupo grupo = grupoRepository.findById(lancamentoDTO.getGrupoId())
                .orElseThrow(() -> new IllegalArgumentException("Grupo não encontrado"));
        lancamentoExistente.setGrupo(grupo);

        return lancamentoRepository.save(lancamentoExistente);
    }

    public void deletarLancamento(Long id) {
        Lancamento lancamento = lancamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lançamento não encontrado"));
        lancamentoRepository.delete(lancamento);
    }
}