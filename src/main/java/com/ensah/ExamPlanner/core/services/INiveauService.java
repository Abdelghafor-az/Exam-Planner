package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Niveau;

import java.util.List;

public interface INiveauService {

	public Niveau getNiveauById(Long id);

	public Niveau getNiveauByNomNiveau(String nomNiveau);

	public void addNiveau(Niveau pNiveau);

	public void updateNiveau(Niveau pNiveau);

	public void deleteNiveau(Long id);

	public List<Niveau> getAllNiveaus();
}
