package com.example.DBPostgre.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DBPostgre.Model.mInquilino;
import com.example.DBPostgre.Repository.rInquilino;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class sInquilino {

    @Autowired
    private rInquilino inquilinoR;

    public List<mInquilino> getAllInquilinos() {
        return inquilinoR.findAll();
    }

    public Optional<mInquilino> getInquilinoById(long id) {
        return inquilinoR.findById(id);
    }

    public mInquilino createInquilino(mInquilino inquilino) {
        return inquilinoR.save(inquilino);
    }

    public mInquilino updateInquilino(long id, mInquilino inquilino) {
        if (inquilinoR.existsById(id)) {
            inquilino.setId(id);
            return inquilinoR.save(inquilino);
        } else {
            return null;
        }
    }

    public void deleteInquilino(long id) {
        if (inquilinoR.existsById(id)) {
            inquilinoR.deleteById(id);
        }
    }


}
