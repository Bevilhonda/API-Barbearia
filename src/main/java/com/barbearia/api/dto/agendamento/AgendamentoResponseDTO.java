package com.barbearia.api.dto.agendamento;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoResponseDTO {

    private Long id;
    private String clienteNome;
    private String barbeiroNome;
    private LocalDate dataAgendamento;
    private LocalTime horario;

    public AgendamentoResponseDTO() {
    }

    public AgendamentoResponseDTO(Long id,
                                  String clienteNome,
                                  String barbeiroNome,
                                  LocalDate dataAgendamento,
                                  LocalTime horario) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.barbeiroNome = barbeiroNome;
        this.dataAgendamento = dataAgendamento;
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getBarbeiroNome() {
        return barbeiroNome;
    }

    public void setBarbeiroNome(String barbeiroNome) {
        this.barbeiroNome = barbeiroNome;
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