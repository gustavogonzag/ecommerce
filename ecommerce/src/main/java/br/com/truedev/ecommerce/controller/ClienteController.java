package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Cliente;
import br.com.truedev.ecommerce.service.cliente.IClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService cliServ;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAll(){
        return ResponseEntity.ok(cliServ.recuperarTodos());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id){
        Cliente result = cliServ.recuperarClientePeloId(id);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> insertNew(@RequestBody Cliente novo){
        try {
            Cliente result = cliServ.cadastrarNovoCliente(novo);
            if (result != null) {
                return ResponseEntity.status(201).body(result);
            }
        } catch (Exception e) {
            System.out.println("LOG: Erro ao cadastrar - " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("clientes/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente){
        cliente.setId(id);
        try {
            Cliente result = cliServ.alterarCliente(cliente);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            System.out.println("LOG: Erro ao atualizar - " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/clientes/busca")
    public ResponseEntity<Cliente> searchByPhone(@RequestParam(name = "telefone") String telefone){
        Cliente result = cliServ.recuperarClientePeloTelefone(telefone);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

}
