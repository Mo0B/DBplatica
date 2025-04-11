package com.example.DBPostgre.Repository;


import com.example.DBPostgre.Model.ReservasParqueaderoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasParqueaderoRepository extends JpaRepository<ReservasParqueaderoModel, Long> {
}
