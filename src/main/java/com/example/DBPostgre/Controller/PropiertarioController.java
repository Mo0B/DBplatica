package com.example.DBPostgre.Controller;

import com.example.DBPostgre.Model.PropietarioModel;
import com.example.DBPostgre.Repository.PropiertarioRepository;
import com.example.DBPostgre.Service.PropietarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/propietario")
public class PropiertarioController {
    private final PropietarioService propietarioService;
    private final PropiertarioRepository propiertarioRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<PropietarioModel>> listar() {
        List<PropietarioModel> lista = propietarioService.M_mostrarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return propietarioService.M_buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("No se encontró el propietario con ID: " + id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<PropietarioModel> guardar(@RequestBody PropietarioModel propietario) {
        PropietarioModel guardado = propietarioService.M_guardar(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
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

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = propietarioService.M_eliminarPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Propietario con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("No se encontró un propietario con ID: " + id);
        }
    }

    @GetMapping("/con-visitantes")
    public List<Object[]> obtenerPropietariosConVisitantes() {
        return propiertarioRepository.obtenerPropietariosConVisitantes();
    }
    @GetMapping("/con-parqueaderos")
    public List<Object[]> obtenerPropietariosConReservasParqueadero() {
        return propiertarioRepository.obtenerPropietariosConReservasParqueadero();
    }
    @GetMapping("/con-zonasocial")
    public List<Object[]> obtenerPropietariosConReservasZonaSocial() {
        return propiertarioRepository.obtenerPropietariosConReservasZonaSocial();
    }


    @GetMapping("/con-visitantes-parqueadero")
    public List<Object[]> obtenerPropietarioConVisitanteYParqueadero() {
        return propiertarioRepository.obtenerPropietarioConVisitanteYParqueadero();
    }

}
