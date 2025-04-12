package com.example.DBPostgre.Repository;

import com.example.DBPostgre.Model.PropietarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropiertarioRepository extends JpaRepository<PropietarioModel, Long> {

    @Query(value = """
    SELECT p.*, v.* FROM propietarios p
    INNER JOIN visitantes v ON v.id_propietario = p.id
""", nativeQuery = true)
    List<Object[]> obtenerPropietariosConVisitantes();

    @Query(value = """
    SELECT p.*, r.* FROM propietarios p
    INNER JOIN reservas_parqueaderos r ON r.id_propietario = p.id
""", nativeQuery = true)
    List<Object[]> obtenerPropietariosConReservasParqueadero();


    @Query(value = """
    SELECT p.*, rz.fecha, rz.hora_inicio, zs.*
    FROM propietarios p
    INNER JOIN Reservas_Zona rz ON rz.id_propietario = p.id
    INNER JOIN Zonas_Sociales zs ON rz.id_zona = zs.id
""", nativeQuery = true)
    List<Object[]> obtenerPropietariosConReservasZonaSocial();

    @Query(value = """
    SELECT p.*, v.*, rp.* FROM propietarios p
    INNER JOIN visitantes v ON v.id_propietario = p.id
    INNER JOIN reservas_parqueaderos rp ON rp.id_propietario = p.id
""", nativeQuery = true)
    List<Object[]> obtenerPropietarioConVisitanteYParqueadero();

}
