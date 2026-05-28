package com.barbearia.api.service;

import com.barbearia.api.entity.Cliente;
import com.barbearia.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorTelefone(String telefone) {
        return clienteRepository.buscarPorTelefone(telefone);
    }

    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.buscarPorNome(nome);
    }
}