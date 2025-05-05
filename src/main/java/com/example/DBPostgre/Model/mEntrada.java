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
@Table(name = "Entradas")
public class mEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime fecha_entrada;
    private LocalDateTime fecha_salida;

    private String categoria;
    private Long referencia;

    @ManyToOne
    private mVigilante vigilante_reg;

    @ManyToOne
    @JoinColumn(name = "id_visitante", nullable = true)
    private mVisitante perVisitante;

    @ManyToOne
    @JoinColumn(name = "id_inquilino", nullable = true)
    private mInquilino perInquilino;

    @ManyToOne
    @JoinColumn(name = "id_mantenimiento", nullable = true)
    private mMantenimiento perMantenimiento;

    @ManyToOne
    @JoinColumn(name = "id_obra", nullable = true)
    private mObra perObra;
}
