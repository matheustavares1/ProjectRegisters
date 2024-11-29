package com.example.RegisterResponsible.exceptions;

public class CpfNotFound extends RuntimeException {
    public CpfNotFound() {
        super();

    }
    public CpfNotFound(String message) {
        super(message);
    }
}
