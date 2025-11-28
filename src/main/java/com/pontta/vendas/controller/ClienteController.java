package com.pontta.vendas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pontta.vendas.domain.Cliente;
import com.pontta.vendas.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity <List<Cliente>> listarCliente(){
        List <Cliente> listaCliente = service.buscarClientes();
        return ResponseEntity.ok(listaCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Cliente> listarPorId(@PathVariable Long id){
        Cliente cliente = service.bucarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity <Cliente> salvarCliente(@RequestBody @Valid Cliente novoCliente){
        Cliente clienteNovo = service.criarCliente(novoCliente);
        return ResponseEntity.status(201).body(clienteNovo);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Cliente> editarCliente(@PathVariable Long id, @RequestBody @Valid Cliente clienteEditado){
        Cliente clienteAlterado = service.alterarCliente(id, clienteEditado);
        return ResponseEntity.ok(clienteAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> excluirCliente(@PathVariable Long id){
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
