package com.barbearia.api.repository;

import com.barbearia.api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("""
            SELECT c
            FROM Cliente c
            WHERE c.telefone = :telefone
            """)
    Cliente buscarPorTelefone(String telefone);

    @Query("""
            SELECT c
            FROM Cliente c
            WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))
            """)
    List<Cliente> buscarPorNome(String nome);
}