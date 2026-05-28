package com.barbearia.api.controller;

import com.barbearia.api.entity.Cliente;
import com.barbearia.api.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
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
}