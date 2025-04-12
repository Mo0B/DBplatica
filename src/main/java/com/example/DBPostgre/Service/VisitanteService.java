package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.VisitanteModel;
import com.example.DBPostgre.Repository.VisitanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VisitanteService {
    private final VisitanteRepository visitanteRepository;

    public VisitanteModel M_guardar(VisitanteModel propietario){
        return visitanteRepository.save(propietario);
    }

    public List<VisitanteModel> M_mostrarTodos() {
        return visitanteRepository.findAll();
    }

    public Optional<VisitanteModel> M_buscarPorId(Long id) {
        return visitanteRepository.findById(id);
    }

    public void M_eliminar(Long id) {
        visitanteRepository.deleteById(id);

    }
    public VisitanteModel M_actualizar(Long id, VisitanteModel datosActualizados) {
        return visitanteRepository.findById(id).map(visitanteExistente -> {
            visitanteExistente.setNombre(datosActualizados.getNombre());
            visitanteExistente.setCedula(datosActualizados.getCedula());
            visitanteExistente.setTelefono(datosActualizados.getTelefono());
            visitanteExistente.setCorreo(datosActualizados.getCorreo());
            visitanteExistente.setPropietarioModel(datosActualizados.getPropietarioModel());
            return visitanteRepository.save(visitanteExistente);
        }).orElseThrow(() -> new RuntimeException("Visitante no encontrado con id: " + id));
    }

    public boolean M_eliminarPorId(Long id) {
        if (visitanteRepository.existsById(id)) {
            visitanteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
