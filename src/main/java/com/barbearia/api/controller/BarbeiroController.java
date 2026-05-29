package com.barbearia.api.controller;

import com.barbearia.api.dto.barbeiro.BarbeiroRequestDTO;
import com.barbearia.api.dto.barbeiro.BarbeiroResponseDTO;
import com.barbearia.api.dto.cliente.ClienteRequestDTO;
import com.barbearia.api.entity.Barbeiro;
import com.barbearia.api.service.BarbeiroService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbeiros")
public class BarbeiroController {

    private final BarbeiroService barbeiroService;

    public BarbeiroController(BarbeiroService barbeiroService) {

        this.barbeiroService = barbeiroService;
    }

    @PostMapping
    public BarbeiroResponseDTO salvar(@RequestBody @Valid BarbeiroRequestDTO dto) {
        return barbeiroService.salvarBarbeiro(dto);
    }

    @GetMapping
    public List<BarbeiroResponseDTO> listar() {

        return barbeiroService.listarBarbeiros();
    }

    @GetMapping("/{id}")
    public BarbeiroResponseDTO buscarPorId(@PathVariable Long id) {

        return barbeiroService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Barbeiro atualizar(
            @PathVariable Long id,
            @RequestBody Barbeiro barbeiro
    ) {
        return barbeiroService.atualizarBarbeiro(id, barbeiro);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {

        boolean deletado = barbeiroService.deletarBarbeiro(id);

        if (!deletado) {
            return "Barbeiro não encontrado";
        }

        return "Barbeiro deletado com sucesso";
    }
}