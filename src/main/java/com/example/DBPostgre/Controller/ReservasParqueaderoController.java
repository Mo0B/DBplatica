package com.example.DBPostgre.Controller;

import com.example.DBPostgre.Model.ReservasParqueaderoModel;
import com.example.DBPostgre.Service.ReservasParqueaderoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/parqueadero")
public class ReservasParqueaderoController {
    private final ReservasParqueaderoService reservasParqueaderoService;

    @GetMapping("/listar")
    public ResponseEntity<List<ReservasParqueaderoModel>> listar() {
        List<ReservasParqueaderoModel> lista = reservasParqueaderoService.M_mostrarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return reservasParqueaderoService.M_buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("No se encontraron las reservas del parqueadero con ID: " + id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<ReservasParqueaderoModel> guardar(@RequestBody ReservasParqueaderoModel parqueadero) {
        ReservasParqueaderoModel guardado = reservasParqueaderoService.M_guardar(parqueadero);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReservasParqueaderoModel> actualizar(
            @PathVariable Long id,
            @RequestBody ReservasParqueaderoModel datosActualizados
    ){
        try {
            ReservasParqueaderoModel datoActualizado = reservasParqueaderoService.M_actualizar(id, datosActualizados);
            return ResponseEntity.ok(datoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = reservasParqueaderoService.M_eliminarPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Propietario con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("No se encontró un propietario con ID: " + id);
        }
    }
}
