package com.example.DBPostgre.Controller;

import com.example.DBPostgre.Model.PropietarioModel;
import com.example.DBPostgre.Service.PropietarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PropiertarioController {
    private final PropietarioService propietarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<PropietarioModel>> listar() {
        List<PropietarioModel> lista = propietarioService.M_mostrarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }



    @PostMapping("/guardar")
    public ResponseEntity<PropietarioModel> guardar(@RequestBody PropietarioModel propietario) {
        PropietarioModel guardado = propietarioService.M_guardar(propietario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(guardado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PropietarioModel> actualizar(
            @PathVariable Long id,
            @RequestBody PropietarioModel datosActualizados
    ){
        try {
            PropietarioModel datoActualizado = propietarioService.M_actualizar(id, datosActualizados);
            return ResponseEntity.ok(datoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
