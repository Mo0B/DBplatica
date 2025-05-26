package com.example.DBPostgre.Repository;

import com.example.DBPostgre.Model.mVigilante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface rVigilante extends JpaRepository<mVigilante, Long> {
    Optional<mVigilante> findByUsuario(String usuario);
}
