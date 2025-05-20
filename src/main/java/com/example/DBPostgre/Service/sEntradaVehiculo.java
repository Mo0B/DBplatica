package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.mInquilino;
import com.example.DBPostgre.Repository.rInquilino;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DBPostgre.Model.mEntradaVehiculo;
import com.example.DBPostgre.Repository.rEntradaVehiculo;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class sEntradaVehiculo {

    @Autowired
    private rEntradaVehiculo entradavehiculoR;

    public List<mEntradaVehiculo> getAllEntradaVehiculos() {
        return entradavehiculoR.findAll();
    }

    public Optional<mEntradaVehiculo> getEntradaVehiculoById(long id) {
        return entradavehiculoR.findById(id);
    }

    public mEntradaVehiculo createEntradaVehiculo(mEntradaVehiculo entradaVehiculo) {
        return entradavehiculoR.save(entradaVehiculo);
    }

    public mEntradaVehiculo updateEntradaVehiculo(long id, mEntradaVehiculo entradaVehiculo) {
        return entradavehiculoR.findById(id).map(entradaVehiculoExistente -> {
            entradaVehiculoExistente.setFecha_entrada(entradaVehiculo.getFecha_entrada());
            entradaVehiculoExistente.setFecha_salida(entradaVehiculo.getFecha_salida());
            entradaVehiculoExistente.setVehiculo(entradaVehiculo.getVehiculo());
            entradaVehiculoExistente.setVigilante_reg(entradaVehiculo.getVigilante_reg());
            return entradavehiculoR.save(entradaVehiculoExistente);
        }).orElseThrow(() -> new RuntimeException("Propietario no encontrado con id: " + id));
    }

    public void deleteEntradaVehiculo(long id) {
        if (entradavehiculoR.existsById(id)) {
            entradavehiculoR.deleteById(id);
        }
    }

}
