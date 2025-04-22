package com.example.DBPostgre.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EstadisticasJugadores")

public class EstadisticasJugadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalTime aMinutosJugador;
    private int aGoles;
    private int aAsistencias;
    private int aTarjetasRojas;
    private int aTarjetasAmarillas;
    @ManyToOne
    @JoinColumn(name = "id_jugador", nullable = false)
    private JugadorModel jugardorModel;
    @ManyToOne
    @JoinColumn(name = "id_partido", nullable = false)
    private PartidoModel partidoModel;
}
