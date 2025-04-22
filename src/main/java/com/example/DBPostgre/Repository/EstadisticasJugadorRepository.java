package com.example.DBPostgre.Repository;
import com.example.DBPostgre.Model.EstadisticasJugadorModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugadorModel, Long> {
}
