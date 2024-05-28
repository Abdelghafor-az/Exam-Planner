package com.ensah;

import com.ensah.ExamPlanner.core.bo.Administrateur;
import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.services.IAdministrateurService;
import com.ensah.ExamPlanner.core.services.IEnseignantService;
import com.ensah.ExamPlanner.core.services.impl.AdministrateurServiceImpl;
import com.ensah.ExamPlanner.core.services.impl.EnseignantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ExamPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamPlannerApplication.class, args);
	}
}
