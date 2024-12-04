package com.example.RegisterResponsible.controllers;

import com.example.RegisterResponsible.entities.Children;

import com.example.RegisterResponsible.services.ChildrenServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/Childrens")
public class ChildrenController {

    private final ChildrenServices services;

    public ChildrenController(ChildrenServices services) {
        this.services = services;
    }

    @PostMapping("/{responsibleId}")
    public ResponseEntity<Children> addChildToResponsible(
            @PathVariable UUID responsibleId,
            @RequestBody Children children) {
        Children savedChild = services.addChildToResponsible(responsibleId, children);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedChild);
    }

    @GetMapping
    public List<Children> findByAllChildrens(){
        return services.getAllChildren();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Children> findByCpf(@PathVariable("cpf") String cpf){
        return services.getChildrenByCpf(cpf);
    }

    @GetMapping("/childrenID/{id}")
    public ResponseEntity<Children> findById(@PathVariable UUID id){
        return services.getChildrenById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteChildren(@PathVariable UUID id){
        services.deleteChildrenByCpf(id);
    }



}
