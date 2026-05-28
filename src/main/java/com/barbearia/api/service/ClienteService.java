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

    public Cliente buscarPorId(Long id) {

        return clienteRepository.findById(id)
                .orElse(null);
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {

        Cliente cliente = clienteRepository.findById(id)
                .orElse(null);

        if (cliente == null) {
            return null;
        }

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setTelefone(clienteAtualizado.getTelefone());

        return clienteRepository.save(cliente);
    }

    public boolean deletarCliente(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElse(null);

        if (cliente == null) {
            return false;
        }

        clienteRepository.delete(cliente);

        return true;
    }
}