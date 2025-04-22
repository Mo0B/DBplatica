package com.example.DBPostgre.Repository;

import com.example.DBPostgre.Model.JugadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface JugadorRepository extends JpaRepository<JugadorModel, Long> {
// Obtener todos los jugadores de un equipo específico
    @Query(value = "SELECT j.* FROM Jugadores j WHERE j.id_equipo = :equipoId", nativeQuery = true)
    List<JugadorModel> nJugadoresPorEquipo(@Param("equipoId") Long equipoId);
// Obtener los jugadores que han marcado más de X goles
    @Query(value = "SELECT j.* FROM Jugadores j " +
            "JOIN Estadisticas_jugadores ej ON ej.id_jugador = j.id " +
            "GROUP BY j.id " +
            "HAVING SUM(ej.a_goles) > :golesMinimos", nativeQuery = true)
    List<JugadorModel> nJugadoresXGoles(@Param("golesMinimos") int golesMinimos);
// Obtener el número total de goles marcados por un equipo en todos sus
//partidos
    @Query(value = "SELECT SUM(p.a_goles_local) + SUM(p.a_goles_visita) " +
            "FROM Partidos p " +
            "WHERE p.equipo_local = :equipoId OR p.equipo_visita = :equipoId", nativeQuery = true)
    int nToltalGolesEquipo(@Param("equipoId") Long equipoId);
// Obtener los resultados de todos los partidos indicando los nombres de
//los equipos
    @Query(value = "SELECT p.id, el.a_nombre AS equipoLocal, ev.a_nombre AS equipoVisitante, p.a_goles_local, p.a_goles_visita, p.a_fecha " +
            "FROM Partidos p " +
            "JOIN Equipos el ON el.id = p.equipo_local " +
            "JOIN Equipos ev ON ev.id = p.equipo_visita", nativeQuery = true)
    List<Object[]> nResultados();

}
