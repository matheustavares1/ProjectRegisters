package com.example.RegisterResponsible.repositories;

import com.example.RegisterResponsible.entities.Responsibles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ResponsiblesRepository extends JpaRepository<Responsibles, UUID> {

    Optional<Responsibles> findByCpf(String cpf);

}
