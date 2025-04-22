package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.EntrenadorModel;
import com.example.DBPostgre.Model.EquipoModel;
import com.example.DBPostgre.Model.PartidoModel;
import com.example.DBPostgre.Repository.PartidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PartidoService {
    private final PartidoRepository partidoRepository;
    /// //////////////////////////////////////////////////
    public PartidoModel M_guardar(PartidoModel partidos){
        return partidoRepository.save(partidos);
    }
    public List<PartidoModel> M_guardarVarios(List<PartidoModel> partidos) {
        return partidoRepository.saveAll(partidos);
    }
    public List<PartidoModel> M_mostrarTodos() {
        return partidoRepository.findAll();
    }

    public Optional<PartidoModel> M_buscarPorId(Long id) {
        return partidoRepository.findById(id);
    }

    public void M_eliminar(Long id) {
        partidoRepository.deleteById(id);

    }
    public PartidoModel M_actualizar(Long id, PartidoModel datosActualizados) {
        return partidoRepository.findById(id).map(partidosExistentes -> {

            partidosExistentes.setAEstadio(datosActualizados.getAEstadio());
            partidosExistentes.setAFecha(datosActualizados.getAFecha());
            partidosExistentes.setAGolesLocal(datosActualizados.getAGolesLocal());
            partidosExistentes.setAGolesVisita(datosActualizados.getAGolesVisita());
            partidosExistentes.setEquipoModel_L(datosActualizados.getEquipoModel_L());
            partidosExistentes.setEquipoModel_V(datosActualizados.getEquipoModel_V());
            return partidoRepository.save(partidosExistentes);
        }).orElseThrow(() -> new RuntimeException("Partido no encontrado con id: " + id));
    }

    public boolean M_eliminarPorId(Long id) {
        if (partidoRepository.existsById(id)) {
            partidoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    /// //////////////////////////////////////////////////
}
