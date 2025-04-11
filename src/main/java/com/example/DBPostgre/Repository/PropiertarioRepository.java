package com.example.DBPostgre.Repository;

import com.example.DBPostgre.Model.PropietarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropiertarioRepository extends JpaRepository<PropietarioModel, Long> {
}
