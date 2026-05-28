package com.barbearia.api.controller;

import com.barbearia.api.entity.Barbeiro;
import com.barbearia.api.service.BarbeiroService;
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
    public Barbeiro salvar(@RequestBody Barbeiro barbeiro) {
        return barbeiroService.salvarBarbeiro(barbeiro);
    }

    @GetMapping
    public List<Barbeiro> listar() {
        return barbeiroService.listarBarbeiros();
    }

    @GetMapping("/{id}")
    public Barbeiro buscarPorId(@PathVariable Long id) {
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