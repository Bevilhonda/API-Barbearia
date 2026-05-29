package com.barbearia.api.service;

import com.barbearia.api.dto.barbeiro.BarbeiroRequestDTO;
import com.barbearia.api.dto.barbeiro.BarbeiroResponseDTO;
import com.barbearia.api.dto.cliente.ClienteResponseDTO;
import com.barbearia.api.entity.Barbeiro;
import com.barbearia.api.entity.Cliente;
import com.barbearia.api.exceptions.ClienteNotFoundException;
import com.barbearia.api.repository.BarbeiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroService(BarbeiroRepository barbeiroRepository) {

        this.barbeiroRepository = barbeiroRepository;
    }

    public BarbeiroResponseDTO salvarBarbeiro(BarbeiroRequestDTO dto) {

        Barbeiro barbeiro = new Barbeiro();

        barbeiro.setNome(dto.getNome());
        barbeiro.setEspecialidade(dto.getEspecialidade());

        Barbeiro barbeiroSalvo = barbeiroRepository.save(barbeiro);

        return new BarbeiroResponseDTO(
                barbeiroSalvo.getId(),
                barbeiroSalvo.getNome(),
                barbeiroSalvo.getEspecialidade()
        );
    }

    public List<BarbeiroResponseDTO> listarBarbeiros() {

        return barbeiroRepository.findAll()
                .stream()
                .map(barbeiro -> new BarbeiroResponseDTO(
                        barbeiro.getId(),
                        barbeiro.getNome(),
                        barbeiro.getEspecialidade()
                ))
                .toList();
    }

    public BarbeiroResponseDTO buscarPorId(Long id) {

        Barbeiro barbeiro = barbeiroRepository.findById(id)
                .orElseThrow(() ->
                        new ClienteNotFoundException(id));

        return new BarbeiroResponseDTO(
                barbeiro.getId(),
                barbeiro.getNome(),
                barbeiro.getEspecialidade()
        );
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