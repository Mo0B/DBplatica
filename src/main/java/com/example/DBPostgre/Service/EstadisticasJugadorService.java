package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.EntrenadorModel;
import com.example.DBPostgre.Model.EquipoModel;
import com.example.DBPostgre.Model.EstadisticasJugadorModel;
import com.example.DBPostgre.Repository.EstadisticasJugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EstadisticasJugadorService {
    private final EstadisticasJugadorRepository estadisticasJugadorRepository;
    /// //////////////////////////////////////////////////
    public EstadisticasJugadorModel M_guardar(EstadisticasJugadorModel estadisticas){
        return estadisticasJugadorRepository.save(estadisticas);
    }
    public List<EstadisticasJugadorModel> M_guardarVarios(List<EstadisticasJugadorModel> estadisticas) {
        return estadisticasJugadorRepository.saveAll(estadisticas);
    }
    public List<EstadisticasJugadorModel> M_mostrarTodos() {
        return estadisticasJugadorRepository.findAll();
    }

    public Optional<EstadisticasJugadorModel> M_buscarPorId(Long id) {
        return estadisticasJugadorRepository.findById(id);
    }

    public void M_eliminar(Long id) {
        estadisticasJugadorRepository.deleteById(id);

    }
    public EstadisticasJugadorModel M_actualizar(Long id, EstadisticasJugadorModel datosActualizados) {
        return estadisticasJugadorRepository.findById(id).map(estadisticasExistentes -> {

            estadisticasExistentes.setAAsistencias(datosActualizados.getAAsistencias());
            estadisticasExistentes.setAMinutosJugador(datosActualizados.getAMinutosJugador());
            estadisticasExistentes.setAGoles(datosActualizados.getAGoles());
            estadisticasExistentes.setATarjetasAmarillas(datosActualizados.getATarjetasAmarillas());
            estadisticasExistentes.setATarjetasRojas(datosActualizados.getATarjetasRojas());
            estadisticasExistentes.setPartidoModel(datosActualizados.getPartidoModel());
            estadisticasExistentes.setJugardorModel(datosActualizados.getJugardorModel());

            return estadisticasJugadorRepository.save(estadisticasExistentes);
        }).orElseThrow(() -> new RuntimeException("Estadisticas de jugador no encontrado con id: " + id));
    }

    public boolean M_eliminarPorId(Long id) {
        if (estadisticasJugadorRepository.existsById(id)) {
            estadisticasJugadorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    /// //////////////////////////////////////////////////
}
