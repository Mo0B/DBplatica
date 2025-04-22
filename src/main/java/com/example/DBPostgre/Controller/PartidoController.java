package com.example.DBPostgre.Controller;


import com.example.DBPostgre.Model.EntrenadorModel;
import com.example.DBPostgre.Model.EquipoModel;
import com.example.DBPostgre.Model.PartidoModel;
import com.example.DBPostgre.Repository.PartidoRepository;
import com.example.DBPostgre.Service.PartidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/partido")
public class PartidoController {
    private final PartidoService partidoService;
    private final PartidoRepository partidoRepository;
    /////////////////////////////////////////////////////////////////////////////
    @GetMapping("/listar")
    public ResponseEntity<List<PartidoModel>> listar() {
        List<PartidoModel> lista = partidoService.M_mostrarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return partidoService.M_buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("No se encontró el partido con ID: " + id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<PartidoModel> guardar(@RequestBody PartidoModel propietario) {
        PartidoModel guardado = partidoService.M_guardar(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }
    @PostMapping("/guardar_varios")
    public ResponseEntity<List<PartidoModel>> guardarVariosEquipos(@RequestBody List<PartidoModel> partidos) {
        List<PartidoModel> guardados = partidoService.M_guardarVarios(partidos);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardados);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PartidoModel> actualizar(
            @PathVariable Long id,
            @RequestBody PartidoModel datosActualizados
    ){
        try {
            PartidoModel datoActualizado = partidoService.M_actualizar(id, datosActualizados);
            return ResponseEntity.ok(datoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = partidoService.M_eliminarPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Partido con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("No se encontró un partido con ID: " + id);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////
}
