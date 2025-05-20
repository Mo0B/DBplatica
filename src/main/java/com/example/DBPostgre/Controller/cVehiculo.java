package com.example.DBPostgre.Controller;
import com.example.DBPostgre.Model.mVehiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.DBPostgre.Service.sVehiculo;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vehiculo")
public class cVehiculo {
    private final sVehiculo vehiculoS;

    @GetMapping("all")
    public List<mVehiculo> getAllVehiculos() {
        return vehiculoS.getAllVehiculos();
    }

    @GetMapping("byId/{id}")
    public Optional<mVehiculo> getVehiculoById(@PathVariable long id) {
        return vehiculoS.getVehiculoById(id);
    }

    @PostMapping("create")
    public mVehiculo createVehiculo(@RequestBody mVehiculo vehiculo) {
        return vehiculoS.createVehiculo(vehiculo);
    }

    @PutMapping("update/{id}")
    public mVehiculo updateVehiculo(@PathVariable long id, @RequestBody mVehiculo vehiculo) {
        return vehiculoS.updateVehiculo(id, vehiculo);
    }

    @DeleteMapping("delete/{id}")
    public void deleteVehiculo(@PathVariable long id) {
        vehiculoS.deleteVehiculo(id);
    }


}
