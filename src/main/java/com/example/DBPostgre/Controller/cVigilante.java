package com.example.DBPostgre.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DBPostgre.Service.sVigilante;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vigilante")
public class cVigilante {
    private final sVigilante vigilante;
}
