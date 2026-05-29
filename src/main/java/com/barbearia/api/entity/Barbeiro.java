package com.barbearia.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "barbeiro")
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "Especialidade não pode ser vazia")
    private String especialidade;

    public Barbeiro() {
    }

    public Barbeiro(Long id,
                    String nome,
                    String especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}