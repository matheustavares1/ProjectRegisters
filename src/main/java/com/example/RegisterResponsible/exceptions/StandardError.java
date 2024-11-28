package com.example.RegisterResponsible.exceptions;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
public class StandardError {

    private Instant dateTime;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
    }
}
