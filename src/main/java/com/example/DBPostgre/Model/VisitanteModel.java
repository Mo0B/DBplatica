package com.example.DBPostgre.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Visitantes",
        uniqueConstraints = @UniqueConstraint(columnNames = {"nombre", "cedula"}))
public class VisitanteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String cedula;

    @Column(nullable = false, length = 50, unique = true)
    private String telefono;

    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_propietario", nullable = false)
    private PropietarioModel propietarioModel;
}
