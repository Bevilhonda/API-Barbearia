package com.barbearia.api.controller;

import com.barbearia.api.entity.Cliente;
import com.barbearia.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.barbearia.api.dto.cliente.ClienteRequestDTO;
import com.barbearia.api.dto.cliente.ClienteResponseDTO;


import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteResponseDTO> listar() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public ClienteResponseDTO salvar(
            @RequestBody @Valid ClienteRequestDTO dto
    ) {
        return clienteService.salvarCliente(dto);
    }

    @GetMapping("/telefone")
    public Cliente buscarPorTelefone(
            @RequestParam String telefone
    ) {
        return clienteService.buscarPorTelefone(telefone);
    }

    @GetMapping("/nome")
    public List<Cliente> buscarPorNome(
            @RequestParam String nome
    ) {
        return clienteService.buscarPorNome(nome);
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO buscarPorId(
            @PathVariable Long id
    ) {
        return clienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(
            @PathVariable Long id,
            @RequestBody Cliente cliente
    ) {
        return clienteService.atualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(
            @PathVariable Long id
    ) {

        clienteService.deletarCliente(id);

        return "Cliente deletado com sucesso";
    }
}