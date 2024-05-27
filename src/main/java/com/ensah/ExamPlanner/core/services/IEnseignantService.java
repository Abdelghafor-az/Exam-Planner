package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Enseignant;

import java.util.List;

public interface IEnseignantService {

	public void addEnseignant(Enseignant pEnseignant);

	public void updateEnseignant(Enseignant pEnseignant);

	public List<Enseignant> getAllEnseignants();

	public void deleteEnseignant(Long id);

	public Enseignant getEnseignantById(Long id);
}
