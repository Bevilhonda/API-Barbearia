package com.barbearia.api.repository;

import com.barbearia.api.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Optional<Agendamento> findByBarbeiroIdAndDataAgendamentoAndHorario(
            Long barbeiroId,
            LocalDate dataAgendamento,
            LocalTime horario
    );
    /* com essa função o Spring vai automaticamente gerar:
    SELECT *
    FROM agendamento
    WHERE barbeiro_id = ?
    AND data_agendamento = ?
    AND horario = ?
    */

}
