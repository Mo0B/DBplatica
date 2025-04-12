package com.example.DBPostgre.Controller;

import com.example.DBPostgre.Model.ZonaSocialModel;

import com.example.DBPostgre.Service.ZonaSocialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/social")
public class ZonaSocialController {
    private final ZonaSocialService zonaSocialService;

    @GetMapping("/listar")
    public ResponseEntity<List<ZonaSocialModel>> listar() {
        List<ZonaSocialModel> lista = zonaSocialService.M_mostrarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return zonaSocialService.M_buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("No se la zona social con ID: " + id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<ZonaSocialModel> guardar(@RequestBody ZonaSocialModel social) {
        ZonaSocialModel guardado = zonaSocialService.M_guardar(social);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ZonaSocialModel> actualizar(
            @PathVariable Long id,
            @RequestBody ZonaSocialModel datosActualizados
    ){
        try {
            ZonaSocialModel datoActualizado = zonaSocialService.M_actualizar(id, datosActualizados);
            return ResponseEntity.ok(datoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = zonaSocialService.M_eliminarPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Propietario con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("No se encontró un propietario con ID: " + id);
        }
    }
}
