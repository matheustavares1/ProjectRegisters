package com.example.RegisterResponsible.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_responsibles")
public class Responsibles {

    public Responsibles() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
   // @Column(name = "name")
    private String name;
    //@Column(name = "email")
    private String  email;
   //@Column(name = "respondible_phone")
    private String phone;
   // @Column(name = "cpf")
    private String cpf;
}
