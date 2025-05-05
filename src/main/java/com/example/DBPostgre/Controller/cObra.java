package com.example.DBPostgre.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DBPostgre.Service.sObra;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/obra")
public class cObra {
    private final sObra obra;
}
