package com.example.DBPostgre.Controller;
import com.example.DBPostgre.Model.mEntradaVehiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.DBPostgre.Service.sEntradaVehiculo;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/entrada-vehiculo")
public class cEntradaVehiculo {
    private final sEntradaVehiculo entradaVehiculoS;

    @GetMapping("all")
    public List<mEntradaVehiculo> getAllEntradaVehiculos() {
        return entradaVehiculoS.getAllEntradaVehiculos();
    }

    @GetMapping("byId/{id}")
    public Optional<mEntradaVehiculo> getEntradaVehiculoById(@PathVariable long id) {
        return entradaVehiculoS.getEntradaVehiculoById(id);
    }

    @PostMapping("create")
    public mEntradaVehiculo createEntradaVehiculo(@RequestBody mEntradaVehiculo entradaVehiculo) {
        return entradaVehiculoS.createEntradaVehiculo(entradaVehiculo);
    }

    @PutMapping("update/{id}")
    public mEntradaVehiculo updateEntradaVehiculo(@PathVariable long id, @RequestBody mEntradaVehiculo entradaVehiculo) {
        return entradaVehiculoS.updateEntradaVehiculo(id, entradaVehiculo);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEntradaVehiculo(@PathVariable long id) {
        entradaVehiculoS.deleteEntradaVehiculo(id);
    }


}
