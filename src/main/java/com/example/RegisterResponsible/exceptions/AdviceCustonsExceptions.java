package com.example.RegisterResponsible.exceptions;

import com.example.RegisterResponsible.entities.Responsibles;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class AdviceCustonsExceptions {

    StandardError err = new StandardError();

    @ExceptionHandler(ConflictCPFExist.class)
    public ResponseEntity<StandardError> cpfExist(ConflictCPFExist exception, HttpServletRequest request) {
        err.setStatus(HttpStatus.CONFLICT.value());
        err.setMessage("CPF ALREADY EXISTING");
        err.setPath(request.getRequestURI());
        err.setDateTime(Instant.now());
        err.setError("CONFLICT_CPF");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> cpfNotFoud(NotFoundException exception, HttpServletRequest request) {
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage("ID DOT FOUND");
        err.setPath(request.getRequestURI());
        err.setDateTime(Instant.now());
        err.setError("NOT_FOUND");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
