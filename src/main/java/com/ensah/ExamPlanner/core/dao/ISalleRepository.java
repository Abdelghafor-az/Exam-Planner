package com.ensah.ExamPlanner.core.dao;

import com.ensah.ExamPlanner.core.bo.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalleRepository extends JpaRepository<Salle, Long> {

    public Salle getSalleByNomSalle(String nomSalle);
}
