package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.EntrenadorModel;
import com.example.DBPostgre.Model.EquipoModel;
import com.example.DBPostgre.Repository.EquipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EquipoService {
    private final EquipoRepository equipoRepository;
    /// //////////////////////////////////////////////////
    public EquipoModel M_guardar(EquipoModel equipo){
        return equipoRepository.save(equipo);
    }

    public List<EquipoModel> M_guardarVarios(List<EquipoModel> equipos) {
        return equipoRepository.saveAll(equipos);
    }

    public List<EquipoModel> M_mostrarTodos() {
        return equipoRepository.findAll();
    }

    public Optional<EquipoModel> M_buscarPorId(Long id) {
        return equipoRepository.findById(id);
    }

    public void M_eliminar(Long id) {
        equipoRepository.deleteById(id);

    }
    public EquipoModel M_actualizar(Long id, EquipoModel datosActualizados) {
        return equipoRepository.findById(id).map(equiposExistentes -> {

            equiposExistentes.setANombre(datosActualizados.getANombre());
            equiposExistentes.setACiudad(datosActualizados.getACiudad());
            equiposExistentes.setAFundacion(datosActualizados.getAFundacion());

            return equipoRepository.save(equiposExistentes);
        }).orElseThrow(() -> new RuntimeException("Equipo no encontrado con id: " + id));
    }

    public boolean M_eliminarPorId(Long id) {
        if (equipoRepository.existsById(id)) {
            equipoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    /// //////////////////////////////////////////////////
}
