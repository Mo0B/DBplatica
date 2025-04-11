package com.example.DBPostgre.Service;


import com.example.DBPostgre.Model.PropietarioModel;
import com.example.DBPostgre.Repository.PropiertarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class PropietarioService {
    private final PropiertarioRepository propiertarioRepository;

    public PropietarioModel M_guardar(PropietarioModel propietario){
        propietario.setHora_entrada(LocalTime.now());
        return propiertarioRepository.save(propietario);
    }

    public List<PropietarioModel> M_mostrarTodos() {
        return propiertarioRepository.findAll();
    }

    public Optional<PropietarioModel> M_buscarPorId(Long id) {
        return propiertarioRepository.findById(id);
    }

    public void M_eliminar(Long id) {
        propiertarioRepository.deleteById(id);

    }
    public PropietarioModel M_actualizar(Long id, PropietarioModel datosActualizados) {
        return propiertarioRepository.findById(id).map(propietarioExistente -> {
            propietarioExistente.setNombre(datosActualizados.getNombre());
            propietarioExistente.setCedula(datosActualizados.getCedula());
            propietarioExistente.setHora_entrada(datosActualizados.getHora_entrada());
            propietarioExistente.setFecha_visita(datosActualizados.getFecha_visita());
            return propiertarioRepository.save(propietarioExistente);
        }).orElseThrow(() -> new RuntimeException("Propietario no encontrado con id: " + id));
    }
}
