package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Examen;

import java.util.List;

public interface IExamenService {

	public void addExamen(Examen pExamen);

	public void updateExamen(Examen pExamen);

	public List<Examen> getAllExamens();

	public void deleteExamen(Long id);

	public Examen getExamenById(Long id);
}
