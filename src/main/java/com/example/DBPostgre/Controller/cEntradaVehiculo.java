package com.example.DBPostgre.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DBPostgre.Service.sEntradaVehiculo;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/entrada-vehiculo")
public class cEntradaVehiculo {
    private final sEntradaVehiculo entradaVehiculo;
}
