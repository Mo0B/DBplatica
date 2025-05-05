package com.example.DBPostgre.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DBPostgre.Service.sVisitante;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/visitante")
public class cVisitante {
    private final sVisitante visitante;
}
