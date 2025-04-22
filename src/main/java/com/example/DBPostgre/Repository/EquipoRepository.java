package com.example.DBPostgre.Repository;
import com.example.DBPostgre.Model.EquipoModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EquipoRepository extends JpaRepository<EquipoModel, Long> {
}
