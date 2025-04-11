package com.example.DBPostgre.Service;

import com.example.DBPostgre.Repository.VisitanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VisitanteService {
    private final VisitanteRepository visitanteRepository;
}
