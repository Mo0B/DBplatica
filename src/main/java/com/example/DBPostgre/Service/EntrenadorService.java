package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.EntrenadorModel;
import com.example.DBPostgre.Model.EquipoModel;
import com.example.DBPostgre.Repository.EntrenadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EntrenadorService {
    private final EntrenadorRepository entrenadorRepository;
    /// //////////////////////////////////////////////////
    public EntrenadorModel M_guardar(EntrenadorModel entrenador){
        return entrenadorRepository.save(entrenador);
    }
    public List<EntrenadorModel> M_guardarVarios(List<EntrenadorModel> entrenadores) {
        return entrenadorRepository.saveAll(entrenadores);
    }
    public List<EntrenadorModel> M_mostrarTodos() {
        return entrenadorRepository.findAll();
    }

    public Optional<EntrenadorModel> M_buscarPorId(Long id) {
        return entrenadorRepository.findById(id);
    }

    public void M_eliminar(Long id) {
        entrenadorRepository.deleteById(id);

    }
    public EntrenadorModel M_actualizar(Long id, EntrenadorModel datosActualizados) {
        return entrenadorRepository.findById(id).map(entrenadoresExistentes -> {

            entrenadoresExistentes.setANombre(datosActualizados.getANombre());
            entrenadoresExistentes.setAEspecialidad(datosActualizados.getAEspecialidad());
            entrenadoresExistentes.setEquipoModel(datosActualizados.getEquipoModel());

            return entrenadorRepository.save(entrenadoresExistentes);
        }).orElseThrow(() -> new RuntimeException("Entrenador no encontrado con id: " + id));
    }

    public boolean M_eliminarPorId(Long id) {
        if (entrenadorRepository.existsById(id)) {
            entrenadorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    /// //////////////////////////////////////////////////
}
