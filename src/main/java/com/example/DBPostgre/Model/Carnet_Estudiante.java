package com.example.DBPostgre.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Carnet_Estudiantes")
public class Carnet_Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(precision = 10)
    private int Codigo;

    @OneToOne
    @JoinColumn(name = "estudiante_id", unique = true)
    private Estudiante estudiante;


}
