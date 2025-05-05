package com.example.DBPostgre.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DBPostgre.Service.sMantenimiento;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mantenimiento")
public class cMantenimiento {
    private final sMantenimiento mantenimiento;
}
