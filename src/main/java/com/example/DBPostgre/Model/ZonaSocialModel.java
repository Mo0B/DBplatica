package com.example.DBPostgre.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Zonas_Sociales")
public class ZonaSocialModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50, unique = true)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String ubicacion;

    @Column(nullable = false, length = 20)
    private int capacidad;
}
