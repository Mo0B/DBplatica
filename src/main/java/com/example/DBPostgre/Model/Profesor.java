package com.example.DBPostgre.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Profesores",
        uniqueConstraints = @UniqueConstraint(columnNames = {"Email"}))

public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "primer_nombre" , nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(name = "primer_apellido" , nullable = false, length = 100, unique = true)
    private String apellido;

    @Column(nullable = false, length = 50, unique = true)
    private String profesion;

    @Column(name = "email" , nullable = false, length = 100, unique = true)
    private String Email;
}
