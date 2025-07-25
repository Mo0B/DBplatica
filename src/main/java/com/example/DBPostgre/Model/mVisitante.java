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
@Table(name = "Visitantes")
public class mVisitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String apellido;
    private String telefono;
    private String num_Documento;
    private String razon;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fecha_visita;

    @ManyToOne
    private mInquilino inquilino;

    @ManyToOne
    private mVigilante vigilante_reg;
}
