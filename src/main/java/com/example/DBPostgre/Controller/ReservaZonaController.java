package com.example.DBPostgre.Controller;

import com.example.DBPostgre.Model.ReservaZonaModel;
import com.example.DBPostgre.Service.ReservaZonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/zona")
public class ReservaZonaController {
    private final ReservaZonaService reservaZonaService;

    @GetMapping("/listar")
    public ResponseEntity<List<ReservaZonaModel>> listar() {
        List<ReservaZonaModel> lista = reservaZonaService.M_mostrarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return reservaZonaService.M_buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("No se encontró la reserva de zona con ID: " + id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<ReservaZonaModel> guardar(@RequestBody ReservaZonaModel zona) {
        ReservaZonaModel guardado = reservaZonaService.M_guardar(zona);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReservaZonaModel> actualizar(
            @PathVariable Long id,
            @RequestBody ReservaZonaModel datosActualizados
    ){
        try {
            ReservaZonaModel datoActualizado = reservaZonaService.M_actualizar(id, datosActualizados);
            return ResponseEntity.ok(datoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = reservaZonaService.M_eliminarPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Propietario con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("No se encontró un propietario con ID: " + id);
        }
    }
}
