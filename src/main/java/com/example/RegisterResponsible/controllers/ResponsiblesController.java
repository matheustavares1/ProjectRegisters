package com.example.RegisterResponsible.controllers;

import com.example.RegisterResponsible.entities.Responsibles;
import com.example.RegisterResponsible.repositories.ResponsiblesRepository;
import com.example.RegisterResponsible.services.ResponsiblesServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/Responsibles")
public class ResponsiblesController {

    private final ResponsiblesServices services;

    public ResponsiblesController(ResponsiblesServices services) {
        this.services = services;
    }


    @PostMapping
    public ResponseEntity<?> createResponsible(@RequestBody Responsibles responsibles) {
        return ResponseEntity.status(HttpStatus.CREATED).body(services.register(responsibles));

    }
    @GetMapping
    public List<Responsibles> getAllResponsibles() {
        return services.buscarRegistros();
    }

    @GetMapping("{id}")
    public ResponseEntity<Responsibles> getIdResponsibles(@PathVariable("id") UUID id) {
        return services.buscarResponsiblePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteResponsible(@PathVariable("id") UUID id) {
        services.deleteResponsible(id);
    }

}
