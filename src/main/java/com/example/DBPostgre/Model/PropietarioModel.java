package com.example.DBPostgre.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Propietarios",
        uniqueConstraints = @UniqueConstraint(columnNames = {"nombre", "cedula"}))

public class PropietarioModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String cedula;

    private LocalDate fecha_visita;

    private LocalTime hora_entrada;
}
