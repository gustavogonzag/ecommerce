package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.service.categoria.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService service;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> recuperarTodas() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> adicionarNova(@RequestBody Categoria nova) {
        Categoria result = service.criarNova(nova);
        if (result != null) {
            return ResponseEntity.status(201).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> alterarCategoria(@PathVariable int id, @RequestBody Categoria categ) {
        categ.setId(id);
        Categoria result = service.alterar(categ);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> removerCategoria(@PathVariable int id) {
        service.apagarCategoria(id);
        return ResponseEntity.ok("Removed!");
    }

}
