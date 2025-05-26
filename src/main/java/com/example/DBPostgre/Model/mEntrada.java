package com.example.DBPostgre.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fecha_entrada;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
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
