package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.*;
import com.example.DBPostgre.Repository.rInquilino;
import com.example.DBPostgre.Repository.rVigilante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DBPostgre.Repository.rVisitante;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class sVisitante {

    @Autowired
    private rVisitante visitanteR;
    @Autowired
    private rVigilante vigilanteRepository;

    @Autowired
    private rInquilino inquilinoRepository;
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
    public mVisitante registrarVisita(requestVisitante request) {
        mVisitante visitante = new mVisitante();

        visitante.setFecha_visita(request.getFecha_visita());

        visitante.setRazon(request.getRazon());

         visitante.setNombre(request.getNombre());
         visitante.setApellido(request.getApellido());
         visitante.setTelefono(request.getTelefono());
         visitante.setNum_Documento(request.getNum_Documento());

        mVigilante vigilante = vigilanteRepository.findById(request.getVigilante_reg())
                .orElseThrow(() -> new RuntimeException("Vigilante no encontrado"));
        visitante.setVigilante_reg(vigilante);

        if (request.getInquilino() != null) {
            mInquilino inquilino = inquilinoRepository.findById(request.getInquilino())
                    .orElseThrow(() -> new RuntimeException("Inquilino no encontrado"));
            visitante.setInquilino(inquilino);
        }
        return visitanteR.save(visitante);
    }
}
