package com.example.DBPostgre.Controller;


import com.example.DBPostgre.Model.EntrenadorModel;
import com.example.DBPostgre.Model.EquipoModel;
import com.example.DBPostgre.Model.JugadorModel;
import com.example.DBPostgre.Repository.JugadorRepository;
import com.example.DBPostgre.Service.EstadisticasJugadorService;
import com.example.DBPostgre.Service.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/jugador")
public class JugadorController {
    private final JugadorService jugadorService;
    private final JugadorRepository jugadorRepository;
    /////////////////////////////////////////////////////////////////////////////
    @GetMapping("/listar")
    public ResponseEntity<List<JugadorModel>> listar() {
        List<JugadorModel> lista = jugadorService.M_mostrarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return jugadorService.M_buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("No se encontró al jugador con ID: " + id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<JugadorModel> guardar(@RequestBody JugadorModel propietario) {
        JugadorModel guardado = jugadorService.M_guardar(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }
    @PostMapping("/guardar_varios")
    public ResponseEntity<List<JugadorModel>> guardarVariosEquipos(@RequestBody List<JugadorModel> jugadores) {
        List<JugadorModel> guardados = jugadorService.M_guardarVarios(jugadores);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardados);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<JugadorModel> actualizar(
            @PathVariable Long id,
            @RequestBody JugadorModel datosActualizados
    ){
        try {
            JugadorModel datoActualizado = jugadorService.M_actualizar(id, datosActualizados);
            return ResponseEntity.ok(datoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = jugadorService.M_eliminarPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Jugador con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("No se encontró un jugador con ID: " + id);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////

    // CONSULTAS NATIVAS
    //Retornamos las consultas
    // Obtener todos los jugadores de un equipo específico
    @GetMapping("/jugadorEquipo/{equipoId}")
    public ResponseEntity<List<JugadorModel>> jugadorEquipo(@PathVariable Long equipoId) {
        List<JugadorModel> jugadores = jugadorRepository.nJugadoresPorEquipo(equipoId);
        if (jugadores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jugadores, HttpStatus.OK);
    }

    // Obtener jugadores que han marcado más de X goles
    @GetMapping("/jugadorGol/{golesMinimos}")
    public ResponseEntity<List<JugadorModel>> jugadorGol(@PathVariable int golesMinimos) {
        List<JugadorModel> jugadores = jugadorRepository.nJugadoresXGoles(golesMinimos);
        if (jugadores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jugadores, HttpStatus.OK);
    }

    // Obtener el número total de goles marcados por un equipo
    @GetMapping("/{equipoId}/gol")
    public ResponseEntity<Integer> equipoGol(@PathVariable Long equipoId) {
        int golesTotales = jugadorRepository.nToltalGolesEquipo(equipoId);
        return new ResponseEntity<>(golesTotales, HttpStatus.OK);
    }

    @GetMapping("/resultados")
    public ResponseEntity<List<Object[]>> obtenerResultadosPartidos() {
        List<Object[]> resultados = jugadorRepository.nResultados();
        if (resultados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(resultados, HttpStatus.OK);
    }

}
