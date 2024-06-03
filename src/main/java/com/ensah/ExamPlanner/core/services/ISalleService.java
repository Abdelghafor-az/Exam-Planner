package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Salle;

import java.util.List;

public interface ISalleService {

	public Salle getSalleById(Long id);

	public Salle getSalleByNomSalle(String nomSalle);

	public void addSalle(Salle pSalle);

	public void updateSalle(Salle pSalle);

	public void deleteSalle(Long id);

	public List<Salle> getAllSalles();
}
