package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Filiere;
import com.ensah.ExamPlanner.core.bo.Groupe;

import java.util.List;

public interface IFiliereService {

	public Filiere getFiliereById(Long id);

	public List<Filiere> getAllFilieres();
}
