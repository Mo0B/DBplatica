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

@Table(name = "Nucleos")
public class Nucleo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("id asc")
    private long id;

    @Column(name = "nombre_nucleo" , nullable = false, length = 50, unique = true)
    private String nombre;
//loco
    @ManyToMany(mappedBy = "nucleo")
    private Set<Estudiante> estudiantes;
}
