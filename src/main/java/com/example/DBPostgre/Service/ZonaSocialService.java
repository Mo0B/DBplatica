package com.example.DBPostgre.Service;

import com.example.DBPostgre.Repository.ZonaSocialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ZonaSocialService {
    private final ZonaSocialRepository zonaSocialRepository;
}
