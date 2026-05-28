package com.barbearia.api.service;

import com.barbearia.api.entity.Cliente;
import com.barbearia.api.exceptions.ClienteNotFoundException;
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
                .orElseThrow(() ->
                        new ClienteNotFoundException(id));
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {

        Cliente cliente = clienteRepository
                .findById(id)
                .orElseThrow(() ->
                        new ClienteNotFoundException(id));

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setTelefone(clienteAtualizado.getTelefone());

        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long id) {

        Cliente cliente = clienteRepository
                .findById(id)
                .orElseThrow(() ->
                        new ClienteNotFoundException(id));

        clienteRepository.delete(cliente);
    }
}