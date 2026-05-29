package com.barbearia.api.dto.agendamento;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoRequestDTO {

    @NotNull(message = "Cliente é obrigatório")
    private Long clienteId;

    @NotNull(message = "Barbeiro é obrigatório")
    private Long barbeiroId;

    @NotNull(message = "Data do agendamento é obrigatória")
    private LocalDate dataAgendamento;

    @NotNull(message = "Horário é obrigatório")
    private LocalTime horario;

    public AgendamentoRequestDTO() {
    }

    public AgendamentoRequestDTO(Long clienteId,
                                 Long barbeiroId,
                                 LocalDate dataAgendamento,
                                 LocalTime horario) {
        this.clienteId = clienteId;
        this.barbeiroId = barbeiroId;
        this.dataAgendamento = dataAgendamento;
        this.horario = horario;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getBarbeiroId() {
        return barbeiroId;
    }

    public void setBarbeiroId(Long barbeiroId) {
        this.barbeiroId = barbeiroId;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
}