package com.example.RegisterResponsible.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(mappedBy = "responsible")
    @JsonManagedReference
    private List<Children> children = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID responsibleId;
   // @Column(name = "name")
    private String name;
    //@Column(name = "email")
    private String  email;
   //@Column(name = "respondible_phone")
    private String phone;
   // @Column(name = "cpf")
    private String cpf;
}
