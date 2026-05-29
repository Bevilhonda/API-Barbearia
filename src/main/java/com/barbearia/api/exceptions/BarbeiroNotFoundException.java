package com.barbearia.api.exception;

public class BarbeiroNotFoundException extends RuntimeException {

    public BarbeiroNotFoundException(Long id) {
        super("Barbeiro com id " + id + " não encontrado");
    }
}