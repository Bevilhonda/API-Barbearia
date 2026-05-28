package com.barbearia.api.service;

import com.barbearia.api.entity.Barbeiro;
import com.barbearia.api.repository.BarbeiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroService(BarbeiroRepository barbeiroRepository) {
        this.barbeiroRepository = barbeiroRepository;
    }

    public Barbeiro salvarBarbeiro(Barbeiro barbeiro) {
        return barbeiroRepository.save(barbeiro);
    }

    public List<Barbeiro> listarBarbeiros() {
        return barbeiroRepository.findAll();
    }

    public Barbeiro buscarPorId(Long id) {
        return barbeiroRepository.findById(id)
                .orElse(null);
    }

    public Barbeiro atualizarBarbeiro(Long id, Barbeiro barbeiroAtualizado) {

        Barbeiro barbeiro = barbeiroRepository.findById(id)
                .orElse(null);

        if (barbeiro == null) {
            return null;
        }

        barbeiro.setNome(barbeiroAtualizado.getNome());
        barbeiro.setEspecialidade(barbeiroAtualizado.getEspecialidade());

        return barbeiroRepository.save(barbeiro);
    }

    public boolean deletarBarbeiro(Long id) {

        Barbeiro barbeiro = barbeiroRepository.findById(id)
                .orElse(null);

        if (barbeiro == null) {
            return false;
        }

        barbeiroRepository.delete(barbeiro);
        return true;
    }
}