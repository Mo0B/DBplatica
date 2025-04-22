package com.example.DBPostgre.Controller;


import com.example.DBPostgre.Model.EntrenadorModel;
import com.example.DBPostgre.Model.EquipoModel;
import com.example.DBPostgre.Model.EstadisticasJugadorModel;
import com.example.DBPostgre.Repository.EstadisticasJugadorRepository;
import com.example.DBPostgre.Service.EstadisticasJugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/estadistica")
public class EstadisticasJugadorController {
    private final EstadisticasJugadorService estadisticasJugadorService;
    private final EstadisticasJugadorRepository estadisticasJugadorRepository;
    /////////////////////////////////////////////////////////////////////////////
    @GetMapping("/listar")
    public ResponseEntity<List<EstadisticasJugadorModel>> listar() {
        List<EstadisticasJugadorModel> lista = estadisticasJugadorService.M_mostrarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return estadisticasJugadorService.M_buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("No se encontraron las estadisticas del jugador con ID: " + id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<EstadisticasJugadorModel> guardar(@RequestBody EstadisticasJugadorModel propietario) {
        EstadisticasJugadorModel guardado = estadisticasJugadorService.M_guardar(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }
    @PostMapping("/guardar_varios")
    public ResponseEntity<List<EstadisticasJugadorModel>> guardarVariosEquipos(@RequestBody List<EstadisticasJugadorModel> estadisticas) {
        List<EstadisticasJugadorModel> guardados = estadisticasJugadorService.M_guardarVarios(estadisticas);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardados);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EstadisticasJugadorModel> actualizar(
            @PathVariable Long id,
            @RequestBody EstadisticasJugadorModel datosActualizados
    ){
        try {
            EstadisticasJugadorModel datoActualizado = estadisticasJugadorService.M_actualizar(id, datosActualizados);
            return ResponseEntity.ok(datoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = estadisticasJugadorService.M_eliminarPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Estadisticas de jugador con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("No se encontraron las estadisticas del jugador con ID: " + id);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////
}
