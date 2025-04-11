package com.example.DBPostgre.Service;

import com.example.DBPostgre.Repository.ReservaZonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservaZonaService {
    private final ReservaZonaRepository reservaZonaRepository;
}
