package com.ensah.ExamPlanner.core.dao;


import com.ensah.ExamPlanner.core.bo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
