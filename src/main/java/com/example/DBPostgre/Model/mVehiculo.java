package com.example.DBPostgre.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Vehiculos")
public class mVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String num_Placa;
    String tipo;

    @ManyToOne
    @JoinColumn(name = "id_inquilino", nullable = true)
    private mInquilino inquilino;

    @ManyToOne
    @JoinColumn(name = "id_visitante", nullable = true)
    private mVisitante visitante;

}
