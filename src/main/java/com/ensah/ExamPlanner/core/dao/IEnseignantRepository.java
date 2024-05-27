package com.ensah.ExamPlanner.core.dao;

import com.ensah.ExamPlanner.core.bo.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnseignantRepository extends JpaRepository<Enseignant, Long> {

}
