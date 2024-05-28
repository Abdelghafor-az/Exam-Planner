package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Personnel;

import java.util.List;

public interface IPersonnelService {

	public void addPersonnel(Personnel pPersonnel);

	public void updatePersonnel(Personnel pPersonnel);

	public List<Personnel> getAllPersonnels();

	public void deletePersonnel(Long id);

	public Personnel getPersonnelById(Long id);
}
