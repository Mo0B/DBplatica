package com.example.DBPostgre.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DBPostgre.Service.sCorrespondencia;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/correspondencia")
public class cCorrespondencia {
private final sCorrespondencia correspondencia;

}
