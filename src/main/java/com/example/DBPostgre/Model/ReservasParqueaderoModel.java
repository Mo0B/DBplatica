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
@Table(name = "Reservas_Parqueaderos")
public class ReservasParqueaderoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate fecha;

    private LocalTime hora_inicio;

    @ManyToOne
    @JoinColumn(name = "id_propietario", nullable = false)
    private PropietarioModel propietarioModel;
}
