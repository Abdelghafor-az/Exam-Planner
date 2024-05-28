package com.ensah.ExamPlanner.core.dao;

import com.ensah.ExamPlanner.core.bo.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonnelRepository extends JpaRepository<Personnel, Long> {

}
