package com.barbearia.api.controller;

import com.barbearia.api.entity.Agendamento;
import com.barbearia.api.service.AgendamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public Agendamento criarAgendamento(
            @RequestParam Long clienteId,
            @RequestParam Long barbeiroId,
            @RequestBody Agendamento agendamento
    ) {
        return agendamentoService.salvar(clienteId, barbeiroId, agendamento);
    }

    @GetMapping
    public List<Agendamento> listar() {
        return agendamentoService.listar();
    }

    @GetMapping("/{id}")
    public Agendamento buscarPorId(@PathVariable Long id) {
        return agendamentoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        agendamentoService.deletar(id);
        return "Agendamento deletado com sucesso";
    }
}