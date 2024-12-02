package com.example.RegisterResponsible.exceptions;

public class ConflictExceptionEmail extends RuntimeException{

    public ConflictExceptionEmail() {
        super();
    }
    public ConflictExceptionEmail(String message) {
        super(message);
    }
}
