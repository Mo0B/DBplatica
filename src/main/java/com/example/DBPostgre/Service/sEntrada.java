package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.*;
import com.example.DBPostgre.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class sEntrada {

    @Autowired
    private rEntrada entradaR;
    @Autowired
    private rVigilante vigilanteRepository;

    @Autowired
    private rInquilino inquilinoRepository;

    @Autowired
    private rVisitante visitanteRepository;

    @Autowired
    private rMantenimiento mantenimientoRepository;

    @Autowired
    private rObra obraRepository;

    public List<mEntrada> getAllEntradas() {
        return entradaR.findAll();
    }

    public Optional<mEntrada> getEntradaById(long id) {
        return entradaR.findById(id);
    }

    public mEntrada createEntrada(mEntrada entrada) {
        return entradaR.save(entrada);
    }

    public mEntrada updateEntrada(long id, mEntrada entrada) {
        return entradaR.findById(id).map(entradaExistente -> {
            entradaExistente.setFecha_entrada(entrada.getFecha_entrada());
            entradaExistente.setFecha_salida(entrada.getFecha_salida());
            entradaExistente.setCategoria(entrada.getCategoria());
            entradaExistente.setReferencia(entrada.getReferencia());
            entradaExistente.setVigilante_reg(entrada.getVigilante_reg());
            entradaExistente.setPerVisitante(entrada.getPerVisitante());
            entradaExistente.setPerInquilino(entrada.getPerInquilino());
            entradaExistente.setPerMantenimiento(entrada.getPerMantenimiento());
            entradaExistente.setPerObra(entrada.getPerObra());
            return entradaR.save(entradaExistente);
        }).orElseThrow(() -> new RuntimeException("Propietario no encontrado con id: " + id));
    }

    public void deleteEntrada(long id) {
        if (entradaR.existsById(id)) {
            entradaR.deleteById(id);
        }
    }


    public mEntrada registrarEntrada(requesEntrada request) {
        mEntrada entrada = new mEntrada();

        entrada.setFecha_entrada(request.getFecha_entrada());

        if (request.getFecha_salida() != null) {
            entrada.setFecha_salida(request.getFecha_salida());
        }

        entrada.setCategoria(request.getCategoria());
        entrada.setReferencia(request.getReferencia());

        mVigilante vigilante = vigilanteRepository.findById(request.getVigilante_reg())
                .orElseThrow(() -> new RuntimeException("Vigilante no encontrado"));
        entrada.setVigilante_reg(vigilante);

        if (request.getPerInquilino() != null) {
            mInquilino inquilino = inquilinoRepository.findById(request.getPerInquilino())
                    .orElseThrow(() -> new RuntimeException("Inquilino no encontrado"));
            entrada.setPerInquilino(inquilino);
        }

        if (request.getPerVisitante() != null) {
            mVisitante visitante = visitanteRepository.findById(request.getPerVisitante())
                    .orElseThrow(() -> new RuntimeException("Visitante no encontrado"));
            entrada.setPerVisitante(visitante);
        }

        if (request.getPerMantenimiento() != null) {
            mMantenimiento manto = mantenimientoRepository.findById(request.getPerMantenimiento())
                    .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado"));
            entrada.setPerMantenimiento(manto);
        }

        if (request.getPerObra() != null) {
            mObra obra = obraRepository.findById(request.getPerObra())
                    .orElseThrow(() -> new RuntimeException("Obra no encontrada"));
            entrada.setPerObra(obra);
        }

        return entradaR.save(entrada);
    }



}
