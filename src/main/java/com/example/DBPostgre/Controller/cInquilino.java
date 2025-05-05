package com.example.DBPostgre.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DBPostgre.Service.sInquilino;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inquilino")
public class cInquilino {
    private final sInquilino inquilino;
}
