package com.example.DBPostgre.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DBPostgre.Service.sEntrada;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/entrada")
public class cEntrada {
    private final sEntrada entrada;
}
