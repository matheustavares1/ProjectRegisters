package com.example.RegisterResponsible.exceptions;

public class ConflictExceptionCpf extends RuntimeException{

    public ConflictExceptionCpf() {
        super();
    }
    public ConflictExceptionCpf(String message) {
        super(message);
    }
}
