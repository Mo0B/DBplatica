package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.ReservasParqueaderoModel;
import com.example.DBPostgre.Repository.ReservasParqueaderoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReservasParqueaderoService {
    private final ReservasParqueaderoRepository reservasParqueaderoRepository;

    public ReservasParqueaderoModel M_guardar(ReservasParqueaderoModel propietario){
        return reservasParqueaderoRepository.save(propietario);
    }

    public List<ReservasParqueaderoModel> M_mostrarTodos() {
        return reservasParqueaderoRepository.findAll();
    }

    public Optional<ReservasParqueaderoModel> M_buscarPorId(Long id) {
        return reservasParqueaderoRepository.findById(id);
    }

    public void M_eliminar(Long id) {
        reservasParqueaderoRepository.deleteById(id);

    }
    public ReservasParqueaderoModel M_actualizar(Long id, ReservasParqueaderoModel datosActualizados) {
        return reservasParqueaderoRepository.findById(id).map(propietarioExistente -> {
            propietarioExistente.setFecha(datosActualizados.getFecha());
            propietarioExistente.setHora_inicio(datosActualizados.getHora_inicio());
            propietarioExistente.setPropietarioModel(datosActualizados.getPropietarioModel());
            return reservasParqueaderoRepository.save(propietarioExistente);
        }).orElseThrow(() -> new RuntimeException("Propietario no encontrado con id: " + id));
    }

    public boolean M_eliminarPorId(Long id) {
        if (reservasParqueaderoRepository.existsById(id)) {
            reservasParqueaderoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
