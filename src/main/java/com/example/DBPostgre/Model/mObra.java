package com.example.DBPostgre.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Obras")
public class mObra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String apellido;
    private String telefono;
    private String num_Documento;
    private String tipo;

    @ManyToOne
    private mInquilino inquilino;
}
