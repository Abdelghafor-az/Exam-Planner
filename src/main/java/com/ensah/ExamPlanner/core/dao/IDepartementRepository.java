package com.ensah.ExamPlanner.core.dao;

import com.ensah.ExamPlanner.core.bo.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartementRepository extends JpaRepository<Departement, Long> {

}
