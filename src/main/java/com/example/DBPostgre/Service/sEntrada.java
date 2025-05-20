package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.mInquilino;
import com.example.DBPostgre.Repository.rInquilino;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DBPostgre.Model.mEntrada;
import com.example.DBPostgre.Repository.rEntrada;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class sEntrada {

    @Autowired
    private rEntrada entradaR;

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

}
