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

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
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
    public String deletarCliente(@PathVariable Long id) {

        boolean deletado =
                clienteService.deletarCliente(id);

        if (!deletado) {
            return "Cliente não encontrado";
        }

        return "Cliente deletado com sucesso";
    }
}