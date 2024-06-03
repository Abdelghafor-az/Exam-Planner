package com.ensah.ExamPlanner.core.dao;

import com.ensah.ExamPlanner.core.bo.Administrateur;
import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.bo.Reservation;
import com.ensah.ExamPlanner.core.bo.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r.salle FROM Reservation r " +
            "WHERE r.date = :date " +
            "AND ((r.heureDebut < :heureFin AND r.heureFin > :heureDebut) " +
            "OR (r.heureDebut >= :heureDebut AND r.heureDebut < :heureFin) " +
            "OR (r.heureFin > :heureDebut AND r.heureFin <= :heureFin))")
    List<Salle> findReservedSalles(@Param("date") LocalDate date,
                                   @Param("heureDebut") LocalTime heureDebut,
                                   @Param("heureFin") LocalTime heureFin);

    @Query("SELECT s FROM Enseignant s WHERE s.idPersonnel IN (" +
            "SELECT e.idPersonnel FROM Reservation r JOIN r.supervisors e " +
            "WHERE r.date = :date " +
            "AND ((r.heureDebut < :heureFin AND r.heureFin > :heureDebut) " +
            "OR (r.heureDebut >= :heureDebut AND r.heureDebut < :heureFin) " +
            "OR (r.heureFin > :heureDebut AND r.heureFin <= :heureFin)))")
    List<Enseignant> findReservedSupervisors(@Param("date") LocalDate date,
                                             @Param("heureDebut") LocalTime heureDebut,
                                             @Param("heureFin") LocalTime heureFin);

    @Query("SELECT a FROM Administrateur a WHERE a.id IN (" +
            "SELECT r.controleur.idPersonnel FROM Reservation r " +
            "WHERE r.date = :date " +
            "AND ((r.heureDebut < :heureFin AND r.heureFin > :heureDebut) " +
            "OR (r.heureDebut >= :heureDebut AND r.heureDebut < :heureFin) " +
            "OR (r.heureFin > :heureDebut AND r.heureFin <= :heureFin)))")
    List<Administrateur> findReservedControleurs(@Param("date") LocalDate date,
                                            @Param("heureDebut") LocalTime heureDebut,
                                            @Param("heureFin") LocalTime heureFin);
}
