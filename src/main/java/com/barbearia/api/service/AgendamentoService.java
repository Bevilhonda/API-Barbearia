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

    public Agendamento salvar(Long clienteId,
                              Long barbeiroId,
                              Agendamento agendamento) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() ->
                        new ClienteNotFoundException(clienteId));

        Barbeiro barbeiro = barbeiroRepository.findById(barbeiroId)
                .orElseThrow(() ->
                        new BarbeiroNotFoundException(barbeiroId));

        // VALIDAÇÃO DE HORÁRIO
        agendamentoRepository
                .findByBarbeiroIdAndDataAgendamentoAndHorario(
                        barbeiroId,
                        agendamento.getDataAgendamento(),
                        agendamento.getHorario()
                )
                .ifPresent(a -> {
                    throw new RuntimeException(
                            "Já existe agendamento para esse barbeiro nesse horário"
                    );
                });

        agendamento.setCliente(cliente);
        agendamento.setBarbeiro(barbeiro);

        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listar() {
        return agendamentoRepository.findAll();
    }

    public Agendamento buscarPorId(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Agendamento não encontrado"));
    }

    public void deletar(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Agendamento não encontrado"));

        agendamentoRepository.delete(agendamento);
    }
}