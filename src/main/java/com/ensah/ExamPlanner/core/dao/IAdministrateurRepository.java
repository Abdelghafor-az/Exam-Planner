package com.ensah.ExamPlanner.core.dao;

import com.ensah.ExamPlanner.core.bo.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdministrateurRepository extends JpaRepository<Administrateur, Long> {

}
