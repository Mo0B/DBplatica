package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.mInquilino;
import com.example.DBPostgre.Repository.rInquilino;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DBPostgre.Model.mVisitante;
import com.example.DBPostgre.Repository.rVisitante;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class sVisitante {

    @Autowired
    private rVisitante visitanteR;

    public List<mVisitante> getAllVisitantes() {
        return visitanteR.findAll();
    }

    public Optional<mVisitante> getVisitanteById(long id) {
        return visitanteR.findById(id);
    }

    public mVisitante createVisitante(mVisitante visitante) {
        return visitanteR.save(visitante);
    }

    public mVisitante updateVisitante(long id, mVisitante visitante) {
        return visitanteR.findById(id).map(visitanteExistente -> {
            visitanteExistente.setNombre(visitante.getNombre());
            visitanteExistente.setApellido(visitante.getApellido());
            visitanteExistente.setTelefono(visitante.getTelefono());
            visitanteExistente.setNum_Documento(visitante.getNum_Documento());
            visitanteExistente.setRazon(visitante.getRazon());
            visitanteExistente.setFecha_visita(visitante.getFecha_visita());
            visitanteExistente.setInquilino(visitante.getInquilino());
            visitanteExistente.setVigilante_reg(visitante.getVigilante_reg());
            return visitanteR.save(visitanteExistente);
        }).orElseThrow(() -> new RuntimeException("Propietario no encontrado con id: " + id));
    }

    public void deleteVisitante(long id) {
        if (visitanteR.existsById(id)) {
            visitanteR.deleteById(id);
        }
    }

}
