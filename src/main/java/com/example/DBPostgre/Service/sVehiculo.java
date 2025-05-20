package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.mInquilino;
import com.example.DBPostgre.Repository.rInquilino;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DBPostgre.Model.mVehiculo;
import com.example.DBPostgre.Repository.rVehiculo;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class sVehiculo {

    @Autowired
    private rVehiculo vehiculoR;

    public List<mVehiculo> getAllVehiculos() {
        return vehiculoR.findAll();
    }

    public Optional<mVehiculo> getVehiculoById(long id) {
        return vehiculoR.findById(id);
    }

    public mVehiculo createVehiculo(mVehiculo vehiculo) {
        return vehiculoR.save(vehiculo);
    }

    public mVehiculo updateVehiculo(long id, mVehiculo vehiculo) {
        return vehiculoR.findById(id).map(vehiculoExistente -> {
            vehiculoExistente.setNum_Placa(vehiculo.getNum_Placa());
            vehiculoExistente.setTipo(vehiculo.getTipo());
            vehiculoExistente.setInquilino(vehiculo.getInquilino());
            vehiculoExistente.setVisitante(vehiculo.getVisitante());
            return vehiculoR.save(vehiculoExistente);
        }).orElseThrow(() -> new RuntimeException("Propietario no encontrado con id: " + id));
    }

    public void deleteVehiculo(long id) {
        if (vehiculoR.existsById(id)) {
            vehiculoR.deleteById(id);
        }
    }

}
