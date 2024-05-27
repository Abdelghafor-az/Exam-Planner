package com.ensah.ExamPlanner.core.dao;

import com.ensah.ExamPlanner.core.bo.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExamenRepository extends JpaRepository<Examen, Long> {

}
