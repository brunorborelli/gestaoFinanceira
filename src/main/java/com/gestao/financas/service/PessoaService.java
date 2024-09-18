package com.gestao.financas.service;

import com.gestao.financas.model.Pessoa;
import com.gestao.financas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> buscarTodas() {
        return pessoaRepository.findAll();
    }

    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }
}