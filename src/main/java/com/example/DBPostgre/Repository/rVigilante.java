package com.example.DBPostgre.Repository;

import com.example.DBPostgre.Model.mVigilante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface rVigilante extends JpaRepository<mVigilante, Long> {
    mVigilante findByUsuario(String usuario);
}
