package com.barbearia.api.controller;

import com.barbearia.api.entity.Agendamento;
import com.barbearia.api.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.barbearia.api.dto.agendamento.AgendamentoRequestDTO;
import com.barbearia.api.dto.agendamento.AgendamentoResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public AgendamentoResponseDTO salvar(
            @RequestBody @Valid AgendamentoRequestDTO dto
    ) {
        return agendamentoService.salvar(dto);
    }

    @GetMapping
    public List<AgendamentoResponseDTO> listar() {
        return agendamentoService.listar();
    }

    @GetMapping("/{id}")
    public AgendamentoResponseDTO buscarPorId(
            @PathVariable Long id
    ) {
        return agendamentoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        agendamentoService.deletar(id);
        return "Agendamento deletado com sucesso";
    }
}