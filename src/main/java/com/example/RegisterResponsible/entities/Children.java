package com.example.RegisterResponsible.entities;


import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;
@ToString
@Getter
@Setter
@Entity
@Table(name = "tb_children")
@NoArgsConstructor
public class Children {

    @ManyToOne
    @JoinColumn(name = "id_responsibles")
    private Responsibles responsible;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String cpf;
    @Column(name = "class")
    @Enumerated(EnumType.STRING)
    private Class classe;


}