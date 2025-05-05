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
@Table(name = "Correspondecias")
public class mCorrespondencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime fecha_entrada;
    private String categoria;
    private String empresa;

    @ManyToOne
    private mInquilino residente;
}
