package com.example.DBPostgre.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EntradasVehiculos")
public class mEntradaVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime fecha_entrada;
    private LocalDateTime  fecha_salida;

    @ManyToOne
    private mVigilante vigilante_reg;

    @ManyToOne
    @JoinColumn(name = "id_Vehiculo", nullable = false)
    private mVehiculo vehiculo;
}
