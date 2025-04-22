package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.EquipoModel;
import com.example.DBPostgre.Model.JugadorModel;
import com.example.DBPostgre.Repository.JugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JugadorService {
    private final JugadorRepository jugadorRepository;
    /// //////////////////////////////////////////////////
    public JugadorModel M_guardar(JugadorModel jugadores){
        return jugadorRepository.save(jugadores);
    }
    public List<JugadorModel> M_guardarVarios(List<JugadorModel> jugadores) {
        return jugadorRepository.saveAll(jugadores);
    }
    public List<JugadorModel> M_mostrarTodos() {
        return jugadorRepository.findAll();
    }

    public Optional<JugadorModel> M_buscarPorId(Long id) {
        return jugadorRepository.findById(id);
    }

    public void M_eliminar(Long id) {
        jugadorRepository.deleteById(id);

    }
    public JugadorModel M_actualizar(Long id, JugadorModel datosActualizados) {
        return jugadorRepository.findById(id).map(jugadoresExistentes -> {

            jugadoresExistentes.setANombre(datosActualizados.getANombre());
            jugadoresExistentes.setAPosicion(datosActualizados.getAPosicion());
            jugadoresExistentes.setEquipoModel(datosActualizados.getEquipoModel());
            jugadoresExistentes.setADorsal(datosActualizados.getADorsal());
            jugadoresExistentes.setANacionalidad(datosActualizados.getANacionalidad());
            jugadoresExistentes.setAFechaNacimiento(datosActualizados.getAFechaNacimiento());

            return jugadorRepository.save(jugadoresExistentes);
        }).orElseThrow(() -> new RuntimeException("Jugador no encontrado con id: " + id));
    }

    public boolean M_eliminarPorId(Long id) {
        if (jugadorRepository.existsById(id)) {
            jugadorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    /// //////////////////////////////////////////////////
}
