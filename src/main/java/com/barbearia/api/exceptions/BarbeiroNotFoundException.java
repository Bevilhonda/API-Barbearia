package com.barbearia.api.exceptions;

public class BarbeiroNotFoundException extends RuntimeException {

    public BarbeiroNotFoundException(Long id) {
        super("Barbeiro com id " + id + " não encontrado");
    }
}