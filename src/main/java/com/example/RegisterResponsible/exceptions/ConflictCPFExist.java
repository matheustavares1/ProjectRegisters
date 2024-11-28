package com.example.RegisterResponsible.exceptions;

public class ConflictCPFExist extends RuntimeException{

    public ConflictCPFExist() {
        super();
    }
    public ConflictCPFExist(String message) {
        super(message);
    }
}
