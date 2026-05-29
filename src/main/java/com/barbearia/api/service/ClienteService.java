package com.barbearia.api.service;

import com.barbearia.api.entity.Cliente;
import com.barbearia.api.exceptions.ClienteNotFoundException;
import com.barbearia.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import com.barbearia.api.dto.cliente.ClienteRequestDTO;
import com.barbearia.api.dto.cliente.ClienteResponseDTO;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO salvarCliente(ClienteRequestDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());

        Cliente clienteSalvo = clienteRepository.save(cliente);

        return new ClienteResponseDTO(
                clienteSalvo.getId(),
                clienteSalvo.getNome(),
                clienteSalvo.getTelefone()
        );
    }

    public List<ClienteResponseDTO> listarClientes() {

        return clienteRepository.findAll()
                .stream()
                .map(cliente -> new ClienteResponseDTO(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getTelefone()
                ))
                .toList();
    }

    public Cliente buscarPorTelefone(String telefone) {
        return clienteRepository.buscarPorTelefone(telefone);
    }

    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.buscarPorNome(nome);
    }

    public ClienteResponseDTO buscarPorId(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() ->
                        new ClienteNotFoundException(id));

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone()
        );
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