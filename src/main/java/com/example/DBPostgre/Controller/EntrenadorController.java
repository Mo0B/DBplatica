package com.example.DBPostgre.Controller;

import com.example.DBPostgre.Model.EntrenadorModel;
import com.example.DBPostgre.Model.EquipoModel;
import com.example.DBPostgre.Repository.EntrenadorRepository;
import com.example.DBPostgre.Service.EntrenadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/entrenador")
public class EntrenadorController {
    private final EntrenadorService entrenadorService;
    private final EntrenadorRepository entrenadorRepository;
    /////////////////////////////////////////////////////////////////////////////
    @GetMapping("/listar")
    public ResponseEntity<List<EntrenadorModel>> listar() {
        List<EntrenadorModel> lista = entrenadorService.M_mostrarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return entrenadorService.M_buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("No se encontró el entrenador con ID: " + id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<EntrenadorModel> guardar(@RequestBody EntrenadorModel entrenador) {
        EntrenadorModel guardado = entrenadorService.M_guardar(entrenador);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }
    @PostMapping("/guardar_varios")
    public ResponseEntity<List<EntrenadorModel>> guardarVariosEquipos(@RequestBody List<EntrenadorModel> entrenadores) {
        List<EntrenadorModel> guardados = entrenadorService.M_guardarVarios(entrenadores);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardados);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EntrenadorModel> actualizar(
            @PathVariable Long id,
            @RequestBody EntrenadorModel datosActualizados
    ){
        try {
            EntrenadorModel datoActualizado = entrenadorService.M_actualizar(id, datosActualizados);
            return ResponseEntity.ok(datoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = entrenadorService.M_eliminarPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Entrenador con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("No se encontró un entrenador con ID: " + id);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////
}
