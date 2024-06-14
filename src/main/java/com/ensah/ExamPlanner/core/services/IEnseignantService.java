package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Departement;
import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.bo.Filiere;

import java.util.List;

public interface IEnseignantService {

	public void addEnseignant(Enseignant pEnseignant);

	public void updateEnseignant(Enseignant pEnseignant);

	public void deleteEnseignant(Long id);

	public Enseignant getEnseignantById(Long id);

	public List<Enseignant> getEnseignantsByIds(List<Long> ids);

	public List<Enseignant> getAllEnseignants();

	// Filiere methods
	public Filiere getFiliereById(Long id);

	public List<Filiere> getAllFilieres();

	// Departement methods
	public Departement getDepartementById(Long id);

	public List<Departement> getAllDepartements();
}
