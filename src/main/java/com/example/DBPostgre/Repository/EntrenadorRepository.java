package com.example.DBPostgre.Repository;
import com.example.DBPostgre.Model.EntrenadorModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EntrenadorRepository extends JpaRepository<EntrenadorModel, Long> {
}
