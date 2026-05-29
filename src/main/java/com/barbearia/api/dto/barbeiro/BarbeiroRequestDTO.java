package com.barbearia.api.dto.barbeiro;

import jakarta.validation.constraints.NotBlank;

public class BarbeiroRequestDTO {

    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "Especialidade não pode ser vazia")
    private String especialidade;

    public BarbeiroRequestDTO() {
    }

    public BarbeiroRequestDTO(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
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