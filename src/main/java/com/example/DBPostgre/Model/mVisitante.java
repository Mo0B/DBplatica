package com.example.DBPostgre.Model;

import jakarta.persistence.*;
import lombok.*;

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
    private String fecha_visita;

    @ManyToOne
    private mInquilino inquilino;

    @ManyToOne
    private mVigilante vigilante_reg;
}
