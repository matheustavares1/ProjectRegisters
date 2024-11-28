package com.example.RegisterResponsible.services;

import com.example.RegisterResponsible.entities.Responsibles;
import com.example.RegisterResponsible.exceptions.ConflictCPFExist;
import com.example.RegisterResponsible.exceptions.NotFoundException;
import com.example.RegisterResponsible.repositories.ResponsiblesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class ResponsiblesServices {

    private final ResponsiblesRepository repository;

    public ResponsiblesServices(ResponsiblesRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> register(Responsibles responsibles) {
        if(repository.findByCpf(responsibles.getCpf()).isPresent()) {
            throw new ConflictCPFExist();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(responsibles));
    }

    public List<Responsibles> buscarRegistros() {
        return repository.findAll();
    }

    public ResponseEntity<Responsibles> buscarResponsiblePorId(UUID id) {
                                                                            //sapoora é lambda
        Responsibles responsible = repository.findById(id).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(responsible);
    }

    public void deleteResponsible(UUID id) {
        repository.deleteById(id);
    }
}






