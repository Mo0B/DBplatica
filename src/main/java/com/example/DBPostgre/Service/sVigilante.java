package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.mInquilino;
import com.example.DBPostgre.Repository.rInquilino;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DBPostgre.Model.mVigilante;
import com.example.DBPostgre.Repository.rVigilante;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class sVigilante {

    @Autowired
    private rVigilante vigilanteR;

    public List<mVigilante> getAllVigilantes() {
        return vigilanteR.findAll();
    }

    public Optional<mVigilante> getVigilanteById(long id) {
        return vigilanteR.findById(id);
    }

    public mVigilante createVigilante(mVigilante vigilante) {
        return vigilanteR.save(vigilante);
    }

    public mVigilante updateVigilante(long id, mVigilante vigilante) {
        if (vigilanteR.existsById(id)) {
            vigilante.setId(id);
            return vigilanteR.save(vigilante);
        } else {
            return null;
        }
    }

    public void deleteVigilante(long id) {
        if (vigilanteR.existsById(id)) {
            vigilanteR.deleteById(id);
        }
    }

}
