package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.ReservaZonaModel;
import com.example.DBPostgre.Repository.ReservaZonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReservaZonaService {
    private final ReservaZonaRepository reservaZonaRepository;

    public ReservaZonaModel M_guardar(ReservaZonaModel propietario){
        return reservaZonaRepository.save(propietario);
    }

    public List<ReservaZonaModel> M_mostrarTodos() {
        return reservaZonaRepository.findAll();
    }

    public Optional<ReservaZonaModel> M_buscarPorId(Long id) {
        return reservaZonaRepository.findById(id);
    }

    public void M_eliminar(Long id) {
        reservaZonaRepository.deleteById(id);

    }
    public ReservaZonaModel M_actualizar(Long id, ReservaZonaModel datosActualizados) {
        return reservaZonaRepository.findById(id).map(ReservaExistente -> {
            ReservaExistente.setFecha(datosActualizados.getFecha());
            ReservaExistente.setHora_inicio(datosActualizados.getHora_inicio());
            ReservaExistente.setZonaSocialModel(datosActualizados.getZonaSocialModel());
            ReservaExistente.setPropietarioModel(datosActualizados.getPropietarioModel());
            return reservaZonaRepository.save(ReservaExistente);
        }).orElseThrow(() -> new RuntimeException("Propietario no encontrado con id: " + id));
    }

    public boolean M_eliminarPorId(Long id) {
        if (reservaZonaRepository.existsById(id)) {
            reservaZonaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
