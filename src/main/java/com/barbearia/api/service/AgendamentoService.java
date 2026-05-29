package com.barbearia.api.service;

import com.barbearia.api.entity.Agendamento;
import com.barbearia.api.entity.Barbeiro;
import com.barbearia.api.entity.Cliente;
import com.barbearia.api.exceptions.ClienteNotFoundException;
import com.barbearia.api.exceptions.BarbeiroNotFoundException;
import com.barbearia.api.repository.AgendamentoRepository;
import com.barbearia.api.repository.BarbeiroRepository;
import com.barbearia.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import com.barbearia.api.dto.agendamento.AgendamentoRequestDTO;
import com.barbearia.api.dto.agendamento.AgendamentoResponseDTO;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;
    private final BarbeiroRepository barbeiroRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository,
                              ClienteRepository clienteRepository,
                              BarbeiroRepository barbeiroRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.clienteRepository = clienteRepository;
        this.barbeiroRepository = barbeiroRepository;
    }

    public AgendamentoResponseDTO salvar(
            AgendamentoRequestDTO dto
    ) {

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() ->
                        new ClienteNotFoundException(dto.getClienteId()));

        Barbeiro barbeiro = barbeiroRepository.findById(dto.getBarbeiroId())
                .orElseThrow(() ->
                        new BarbeiroNotFoundException(dto.getBarbeiroId()));

        // validação de horário
        agendamentoRepository
                .findByBarbeiroIdAndDataAgendamentoAndHorario(
                        dto.getBarbeiroId(),
                        dto.getDataAgendamento(),
                        dto.getHorario()
                )
                .ifPresent(a -> {
                    throw new RuntimeException(
                            "Já existe agendamento para esse barbeiro nesse horário"
                    );
                });

        Agendamento agendamento = new Agendamento();

        agendamento.setCliente(cliente);
        agendamento.setBarbeiro(barbeiro);
        agendamento.setDataAgendamento(dto.getDataAgendamento());
        agendamento.setHorario(dto.getHorario());

        Agendamento salvo = agendamentoRepository.save(agendamento);

        return new AgendamentoResponseDTO(
                salvo.getId(),
                salvo.getCliente().getNome(),
                salvo.getBarbeiro().getNome(),
                salvo.getDataAgendamento(),
                salvo.getHorario()
        );
    }

    public List<AgendamentoResponseDTO> listar() {

        return agendamentoRepository.findAll()
                .stream()
                .map(agendamento -> new AgendamentoResponseDTO(
                        agendamento.getId(),
                        agendamento.getCliente().getNome(),
                        agendamento.getBarbeiro().getNome(),
                        agendamento.getDataAgendamento(),
                        agendamento.getHorario()
                ))
                .toList();
    }

    public AgendamentoResponseDTO buscarPorId(Long id) {

        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Agendamento não encontrado"));

        return new AgendamentoResponseDTO(
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getBarbeiro().getNome(),
                agendamento.getDataAgendamento(),
                agendamento.getHorario()
        );
    }

    public void deletar(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Agendamento não encontrado"));

        agendamentoRepository.delete(agendamento);
    }
}