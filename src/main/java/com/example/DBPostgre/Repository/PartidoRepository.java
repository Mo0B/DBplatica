package com.example.DBPostgre.Repository;

import com.example.DBPostgre.Model.PartidoModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PartidoRepository extends JpaRepository<PartidoModel, Long> {
}
