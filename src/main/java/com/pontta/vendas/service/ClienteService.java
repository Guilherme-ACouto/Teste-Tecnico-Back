package com.pontta.vendas.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.pontta.vendas.domain.Cliente;
import com.pontta.vendas.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public List <Cliente> buscarClientes(){
        return repository.findAll();
    }

    public Cliente bucarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Cliente com o ID " + id + " não cadastrado."));
    }

    public Cliente criarCliente(Cliente novoCliente){
        if (repository.existsByEmail(novoCliente.getEmail())){
            throw new IllegalArgumentException("O email informado " + novoCliente.getEmail() + " já está cadastrado");
        }
        return repository.save(novoCliente);
    }

    public Cliente alterarCliente(Long id, Cliente clienteEditado){
        Cliente clienteAlterado = bucarPorId(id);
        clienteAlterado.setNome(clienteEditado.getNome());
        clienteAlterado.setEmail(clienteEditado.getEmail());
        return repository.save(clienteAlterado);
    }

    public void deletarCliente(Long id){
        Cliente clienteExcluido = bucarPorId(id);
        repository.delete(clienteExcluido);
    }

}
