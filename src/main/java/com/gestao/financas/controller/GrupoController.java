package com.gestao.financas.controller;

import com.gestao.financas.dto.GrupoDTO;
import com.gestao.financas.model.Grupo;
import com.gestao.financas.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> buscarGrupoPorId(@PathVariable Long id) {
        Optional<Grupo> grupo = grupoService.buscarPorId(id);
        return grupo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Grupo>> listarGrupos() {
        List<Grupo> grupos = grupoService.buscarTodos();
        return ResponseEntity.ok(grupos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirGrupo(@PathVariable Long id) {
        grupoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/criar")
    public ResponseEntity<Grupo> criarGrupo(@RequestBody GrupoDTO grupoDTO) {
        Grupo grupo = grupoService.salvarGrupo(grupoDTO);
        return ResponseEntity.ok(grupo);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Grupo> salvarGrupo(@RequestBody Grupo grupo) {
        Grupo grupoSalvo = grupoService.salvar(grupo);
        return ResponseEntity.ok(grupoSalvo);
    }
}