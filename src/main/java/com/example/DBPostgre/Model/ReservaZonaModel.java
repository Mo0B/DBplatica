package com.example.DBPostgre.Model;

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
@Table(name = "Reservas_Zona")
public class ReservaZonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate fecha;

    private LocalTime hora_inicio;

    @ManyToOne
    @JoinColumn(name = "id_propietario", nullable = false)
    private PropietarioModel propietarioModel;

    @ManyToOne
    @JoinColumn(name = "id_zona", nullable = false)
    private ZonaSocialModel zonaSocialModel;
}
