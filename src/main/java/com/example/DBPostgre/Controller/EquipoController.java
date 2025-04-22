package com.example.DBPostgre.Controller;


import com.example.DBPostgre.Model.EntrenadorModel;
import com.example.DBPostgre.Model.EquipoModel;
import com.example.DBPostgre.Repository.EquipoRepository;
import com.example.DBPostgre.Service.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/equipo")
public class EquipoController {
    private final EquipoService equipoService;
    private final EquipoRepository equipoRepository;
    /////////////////////////////////////////////////////////////////////////////
    @GetMapping("/listar")
    public ResponseEntity<List<EquipoModel>> listar() {
        List<EquipoModel> lista = equipoService.M_mostrarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return equipoService.M_buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("No se encontró el equipo con ID: " + id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<EquipoModel> guardar(@RequestBody EquipoModel propietario) {
        EquipoModel guardado = equipoService.M_guardar(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PostMapping("/guardar_varios")
    public ResponseEntity<List<EquipoModel>> guardarVariosEquipos(@RequestBody List<EquipoModel> equipos) {
        List<EquipoModel> guardados = equipoService.M_guardarVarios(equipos);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardados);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EquipoModel> actualizar(
            @PathVariable Long id,
            @RequestBody EquipoModel datosActualizados
    ){
        try {
            EquipoModel datoActualizado = equipoService.M_actualizar(id, datosActualizados);
            return ResponseEntity.ok(datoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = equipoService.M_eliminarPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Equipo con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("No se encontró un equipo con ID: " + id);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////
}
