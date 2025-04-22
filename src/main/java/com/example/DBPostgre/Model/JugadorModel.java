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
@Table(name = "Jugadores")

public class JugadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String aNombre;
    private String aPosicion;
    private int aDorsal;
    private LocalDate aFechaNacimiento;
    private  String aNacionalidad;@ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private EquipoModel equipoModel;
}
