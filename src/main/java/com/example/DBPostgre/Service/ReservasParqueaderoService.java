package com.example.DBPostgre.Service;

import com.example.DBPostgre.Repository.ReservasParqueaderoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservasParqueaderoService {
    private final ReservasParqueaderoRepository reservasParqueaderoRepository;
}
