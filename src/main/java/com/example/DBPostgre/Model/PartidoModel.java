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
@Table(name = "Partidos")

public class PartidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String aEstadio;
    private LocalDate aFecha;
    private int aGolesLocal;
    private int aGolesVisita;

    @ManyToOne
    @JoinColumn(name = "equipo_local", nullable = false)
    private EquipoModel equipoModel_L;
    @ManyToOne
    @JoinColumn(name = "equipo_visita", nullable = false)
    private EquipoModel equipoModel_V;
}
