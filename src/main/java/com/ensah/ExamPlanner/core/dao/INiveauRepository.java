package com.ensah.ExamPlanner.core.dao;

import com.ensah.ExamPlanner.core.bo.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INiveauRepository extends JpaRepository<Niveau, Long> {

    public Niveau getNiveauByNomNiveau(String nomNiveau);
}
