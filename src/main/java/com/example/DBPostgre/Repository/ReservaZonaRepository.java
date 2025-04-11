package com.example.DBPostgre.Repository;


import com.example.DBPostgre.Model.ReservaZonaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaZonaRepository extends JpaRepository<ReservaZonaModel, Long> {
}
