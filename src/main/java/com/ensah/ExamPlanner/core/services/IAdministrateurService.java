package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Administrateur;

import java.util.List;

public interface IAdministrateurService {

	public void addAdministrateur(Administrateur pAdministrateur);

	public void updateAdministrateur(Administrateur pAdministrateur);

	public List<Administrateur> getAllAdministrateurs();

	public void deleteAdministrateur(Long id);

	public Administrateur getAdministrateurById(Long id);
}
