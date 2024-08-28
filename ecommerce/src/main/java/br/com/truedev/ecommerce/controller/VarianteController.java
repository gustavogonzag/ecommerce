package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;
import br.com.truedev.ecommerce.service.variante.IVarianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VarianteController {

    @Autowired
    private IVarianteService service;

    @PostMapping("/variantes")
    public ResponseEntity<Variante> adicionar(@RequestBody Variante variante) {
        Variante v = service.adicionarNova(variante);
        if (v != null) {
            return ResponseEntity.ok().body(v);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/variantes/{id}")
    public ResponseEntity<Variante> modificar(@RequestBody Variante variante, @PathVariable int id) {
        variante.setId(id);
        Variante var = service.alterarDados(variante);
        if (var != null) {
            return ResponseEntity.ok().body(var);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/variantes/{id}")
    public ResponseEntity<Variante> buscarPorId(@PathVariable int id) {
        Variante var = service.recuperarPorId(id);
        if (var != null) {
            return ResponseEntity.ok().body(var);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/variantes")
    public ResponseEntity<List<Variante>> listar(@RequestParam(name = "idProduto") Integer idProduto) {
        Produto p = new Produto();
        p.setId(idProduto);
        return ResponseEntity.ok(service.recuperarPorProduto(p));
    }
}
