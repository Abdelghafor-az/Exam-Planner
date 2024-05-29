package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Enseignant;

import java.util.List;

public interface IEnseignantService {

	public void addEnseignant(Enseignant pEnseignant);

	public void updateEnseignant(Enseignant pEnseignant);

	public void deleteEnseignant(Long id);

	public Enseignant getEnseignantById(Long id);

	public List<Enseignant> getEnseignantsByIds(List<Long> ids);

	public List<Enseignant> getAllEnseignants();
}
