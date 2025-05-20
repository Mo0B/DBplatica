package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.mInquilino;
import com.example.DBPostgre.Repository.rInquilino;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DBPostgre.Model.mMantenimiento;
import com.example.DBPostgre.Repository.rMantenimiento;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class sMantenimiento {

    @Autowired
    private rMantenimiento mantenimientoR;

    public List<mMantenimiento> getAllMantenimientos() {
        return mantenimientoR.findAll();
    }

    public Optional<mMantenimiento> getMantenimientoById(long id) {
        return mantenimientoR.findById(id);
    }

    public mMantenimiento createMantenimiento(mMantenimiento mantenimiento) {
        return mantenimientoR.save(mantenimiento);
    }

    public mMantenimiento updateMantenimiento(long id, mMantenimiento mantenimiento) {
        if (mantenimientoR.existsById(id)) {
            mantenimiento.setId(id);
            return mantenimientoR.save(mantenimiento);
        } else {
            return null;
        }
    }

    public void deleteMantenimiento(long id) {
        if (mantenimientoR.existsById(id)) {
            mantenimientoR.deleteById(id);
        }
    }

}
