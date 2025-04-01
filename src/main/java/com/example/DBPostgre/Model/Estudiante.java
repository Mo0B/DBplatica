package com.example.DBPostgre.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Estudiantes",
        uniqueConstraints = @UniqueConstraint(columnNames = {"nombre", "apellido"}))
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OrderBy("primer_apellido asc")
    @Column(name = "primer_nombre" , nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(name = "primer_apellido" , nullable = true, length = 100, unique = true)
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesor profesor;

    @ManyToMany
    @JoinTable(
            name = "estudiantes-nucleos",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "nucleo_id")
    )
    private Set<Nucleo> nucleo;

    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Carnet_Estudiante carnet_estudiante;
}
