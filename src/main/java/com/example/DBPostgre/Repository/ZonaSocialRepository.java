package com.example.DBPostgre.Repository;


import com.example.DBPostgre.Model.ZonaSocialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaSocialRepository extends JpaRepository<ZonaSocialModel, Long> {
}
