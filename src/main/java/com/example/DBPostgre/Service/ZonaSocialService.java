package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.ZonaSocialModel;
import com.example.DBPostgre.Repository.ZonaSocialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ZonaSocialService {
    private final ZonaSocialRepository zonaSocialRepository;

    public ZonaSocialModel M_guardar(ZonaSocialModel propietario){
        return zonaSocialRepository.save(propietario);
    }

    public List<ZonaSocialModel> M_mostrarTodos() {
        return zonaSocialRepository.findAll();
    }

    public Optional<ZonaSocialModel> M_buscarPorId(Long id) {
        return zonaSocialRepository.findById(id);
    }

    public void M_eliminar(Long id) {
        zonaSocialRepository.deleteById(id);

    }
    public ZonaSocialModel M_actualizar(Long id, ZonaSocialModel datosActualizados) {
        return zonaSocialRepository.findById(id).map(ZonaSocialExistente -> {
            ZonaSocialExistente.setNombre(datosActualizados.getNombre());
            ZonaSocialExistente.setUbicacion(datosActualizados.getUbicacion());
            ZonaSocialExistente.setCapacidad(datosActualizados.getCapacidad());
            return zonaSocialRepository.save(ZonaSocialExistente);
        }).orElseThrow(() -> new RuntimeException("Propietario no encontrado con id: " + id));
    }

    public boolean M_eliminarPorId(Long id) {
        if (zonaSocialRepository.existsById(id)) {
            zonaSocialRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
