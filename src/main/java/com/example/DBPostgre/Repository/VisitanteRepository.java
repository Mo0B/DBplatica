package com.example.DBPostgre.Repository;

import com.example.DBPostgre.Model.VisitanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<VisitanteModel, Long> {
}
