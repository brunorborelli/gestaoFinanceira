package com.gestao.financas.controller;

import com.gestao.financas.dto.LancamentoDTO;
import com.gestao.financas.model.Lancamento;
import com.gestao.financas.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @PostMapping("/criar")
    public Lancamento criarLancamento(@RequestBody LancamentoDTO lancamentoDTO) {
        return lancamentoService.criarLancamento(
                lancamentoDTO.getGrupoId(),
                lancamentoDTO.getNome(),
                lancamentoDTO.getDescricao(),
                lancamentoDTO.getData(),
                lancamentoDTO.getTipo(),
                lancamentoDTO.getValor(),
                lancamentoDTO.getCategoria()
        );
    }

    @GetMapping("/{id}")
    public Optional<Lancamento> buscarLancamentoPorId(@PathVariable Long id) {
        return lancamentoService.buscarPorId(id);
    }

    @GetMapping("/listar")
    public List<Lancamento> listarLancamentos() {
        return lancamentoService.listarTodos();
    }

    @PutMapping("/atualizar/{id}")
    public Lancamento atualizarLancamento(@PathVariable Long id, @RequestBody LancamentoDTO lancamentoDTO) {
        return lancamentoService.atualizarLancamento(id, lancamentoDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarLancamento(@PathVariable Long id) {
        lancamentoService.deletarLancamento(id);
    }
}