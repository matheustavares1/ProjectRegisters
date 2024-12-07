package com.example.RegisterResponsible.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class AdviceCustonsExceptions {

    StandardError err = new StandardError();

    @ExceptionHandler(ConflictExceptionCpf.class)
    public ResponseEntity<StandardError> cpfExist(ConflictExceptionCpf exception, HttpServletRequest request) {
        err.setStatus(HttpStatus.CONFLICT.value());
        err.setMessage("CPF ALREADY EXISTING");
        err.setPath(request.getRequestURI());
        err.setDateTime(Instant.now());
        err.setError("CONFLICT_CPF");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<StandardError> idNotFoud(IdNotFoundException exception, HttpServletRequest request) {
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage("ID DOT FOUND");
        err.setPath(request.getRequestURI());
        err.setDateTime(Instant.now());
        err.setError("NOT_FOUND");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(CpfNotFound.class)
    public ResponseEntity<StandardError> findByCpf(CpfNotFound exception, HttpServletRequest request) {
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage("CPF NOT EXIST");
        err.setPath(request.getRequestURI());
        err.setDateTime(Instant.now());
        err.setError("NOT_FOUND");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    @ExceptionHandler(ConflictExceptionEmail.class)
    public ResponseEntity<StandardError> emailExist(ConflictExceptionEmail exception, HttpServletRequest request) {
        err.setStatus(HttpStatus.CONFLICT.value());
        err.setMessage("EMAIL EXIST");
        err.setPath(request.getRequestURI());
        err.setDateTime(Instant.now());
        err.setError("CONFLICT_EMAIL");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);

    }
    @ExceptionHandler(ConflictExceptionEnrollment.class)
    public ResponseEntity<StandardError> enrollmentExist(ConflictExceptionEnrollment exception, HttpServletRequest request) {
        err.setStatus(HttpStatus.CONFLICT.value());
        err.setMessage("SCHOOL ENROLLMENT EXIST");
        err.setPath(request.getRequestURI());
        err.setDateTime(Instant.now());
        err.setError("CONFLICT_SCHOLENROLLMENT");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);

    }
    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<StandardError> enrollmentExist(PSQLException exception, HttpServletRequest request) {
        err.setStatus(HttpStatus.CONFLICT.value());
        err.setMessage("SCHOOL ENROLLMENT EXIST");
        err.setPath(request.getRequestURI());
        err.setDateTime(Instant.now());
        err.setError("CONFLICT_SCHOLENROLLMENT");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);

    }
}
