package com.example.DBPostgre.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Entrenadores")

public class EntrenadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String aNombre;
    private String aEspecialidad;
    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private EquipoModel equipoModel;
}
