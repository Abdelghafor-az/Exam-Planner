package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Personne;

import java.util.List;

public interface IPersonneService {

	public void addPersonne(Personne pPersonne);

	public void updatePersonne(Personne pPersonne);

	public List<Personne> getAllPersonnes();

	public void deletePersonne(Long id);

	public Personne getPersonneById(Long id);
}
