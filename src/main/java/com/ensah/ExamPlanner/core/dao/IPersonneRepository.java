package com.ensah.ExamPlanner.core.dao;

import com.ensah.ExamPlanner.core.bo.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonneRepository extends JpaRepository<Personne, Long> {

}
