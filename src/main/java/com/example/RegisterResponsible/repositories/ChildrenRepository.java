package com.example.RegisterResponsible.repositories;

import com.example.RegisterResponsible.entities.Children;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ChildrenRepository extends JpaRepository<Children, UUID> {

    Optional<Children> findByCpf(String cpf);

    @Query("SELECT MAX(c.childrenEnrollment) FROM Children c")
    Optional<Integer> findMaxSchoolEnrollment();



}
