package com.example.DBPostgre.Model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class mVigilanteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String numDocumento;
    private String turno;
    private String usuario;
    private Boolean accion;

}
