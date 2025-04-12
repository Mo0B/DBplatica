package com.example.DBPostgre.Controller;


import com.example.DBPostgre.Model.VisitanteModel;

import com.example.DBPostgre.Service.VisitanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/visitante")
public class VisitanteController {
    private final VisitanteService visitanteService;

    @GetMapping("/listar")
    public ResponseEntity<List<VisitanteModel>> listar() {
        List<VisitanteModel> lista = visitanteService.M_mostrarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return visitanteService.M_buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("No se encontró el visitante con ID: " + id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<VisitanteModel> guardar(@RequestBody VisitanteModel visitante) {
        VisitanteModel guardado = visitanteService.M_guardar(visitante);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<VisitanteModel> actualizar(
            @PathVariable Long id,
            @RequestBody VisitanteModel datosActualizados
    ){
        try {
            VisitanteModel datoActualizado = visitanteService.M_actualizar(id, datosActualizados);
            return ResponseEntity.ok(datoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = visitanteService.M_eliminarPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Propietario con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("No se encontró un propietario con ID: " + id);
        }
    }
}
