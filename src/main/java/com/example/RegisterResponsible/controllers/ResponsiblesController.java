package com.example.RegisterResponsible.controllers;


import com.example.RegisterResponsible.entities.Responsibles;
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


    //METODO PARA ADICIONAR/SALVAR RESPONSAVEL
    @PostMapping
    public ResponseEntity<?> createResponsible(@RequestBody Responsibles responsibles) {
        return ResponseEntity.status(HttpStatus.CREATED).body(services.register(responsibles));

    }
    //METODO PARA LISTAR TODOS OS RESPONSAVEIS
    @GetMapping("/all")
    public List<Responsibles> getAllResponsibles() {
        return services.buscarRegistros();
    }

    //METODO PARA BUSCAR REPSONSAVEL POR ID
    @GetMapping("{id}")
    public ResponseEntity<Responsibles> getIdResponsibles(@PathVariable("id") UUID id) {
        return services.buscarResponsiblePorId(id);
    }

    //METODO PARA DELETAR RESPONSAVE
    @DeleteMapping("/deleteResponsibles/{responsibleId}")
    public void deleteResponsible(@PathVariable("responsibleId") UUID responsibleId) {
        services.deleteResponsible(responsibleId);
    }
    //METODO PARA BUSCAR RESPONSAVEL POR CPF
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Responsibles> findByCpf(@PathVariable String cpf) {
        return services.findByCpf(cpf);
    }

    //METODO PARA ATUALIZAR RESPONSAVEL
    @PutMapping("/update/{id}")
    public ResponseEntity<Responsibles> updateResponsible(@PathVariable UUID id, @RequestBody Responsibles responsibles) {
        Responsibles newResponsibles = services.upadateResponsible(id, responsibles);
        return ResponseEntity.ok(newResponsibles);
    }



}
