package com.example.DBPostgre.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DBPostgre.Service.sVehiculo;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vehiculo")
public class cVehiculo {
    private final sVehiculo vehiculo;
}
