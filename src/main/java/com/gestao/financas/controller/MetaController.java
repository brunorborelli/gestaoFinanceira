package com.gestao.financas.controller;

import com.gestao.financas.dto.MetaDTO;
import com.gestao.financas.model.Meta;
import com.gestao.financas.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @PostMapping("/criar")
    public ResponseEntity<Meta> criarMeta(@RequestBody MetaDTO metaDTO) {
        Meta meta = metaService.salvarMeta(metaDTO);
        return ResponseEntity.ok(meta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meta> buscarMetaPorId(@PathVariable Long id) {
        Optional<Meta> meta = metaService.buscarPorId(id);
        return meta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Meta>> listarMetas() {
        List<Meta> metas = metaService.listarTodos();
        return ResponseEntity.ok(metas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMeta(@PathVariable Long id) {
        metaService.deletarMeta(id);
        return ResponseEntity.noContent().build();
    }
}