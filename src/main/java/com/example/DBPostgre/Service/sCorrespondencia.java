package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.mInquilino;
import com.example.DBPostgre.Repository.rInquilino;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.DBPostgre.Model.mCorrespondencia;
import com.example.DBPostgre.Repository.rCorrespondencia;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class sCorrespondencia {

    @Autowired
    private rCorrespondencia correspondenciaR;

    public List<mCorrespondencia> getAllCorrespondencias() {
        return correspondenciaR.findAll();
    }

    public Optional<mCorrespondencia> getCorrespondenciaById(long id) {
        return correspondenciaR.findById(id);
    }

    public mCorrespondencia createCorrespondencia(mCorrespondencia Correspondencia) {
        return correspondenciaR.save(Correspondencia);
    }

    public mCorrespondencia updateCorrespondencia(long id, mCorrespondencia CorrespondenciaActualizada) {
        return correspondenciaR.findById(id).map(CorrespondenciaExistente -> {
            CorrespondenciaExistente.setFecha_entrada(CorrespondenciaActualizada.getFecha_entrada());
            CorrespondenciaExistente.setEmpresa(CorrespondenciaActualizada.getEmpresa());
            CorrespondenciaExistente.setCategoria(CorrespondenciaActualizada.getCategoria());
            CorrespondenciaExistente.setInquilino(CorrespondenciaActualizada.getInquilino());
            return correspondenciaR.save(CorrespondenciaExistente);
        }).orElseThrow(() -> new RuntimeException("Propietario no encontrado con id: " + id));
    }

    public void deleteCorrespondencia(long id) {
        if (correspondenciaR.existsById(id)) {
            correspondenciaR.deleteById(id);
        }
    }
}
