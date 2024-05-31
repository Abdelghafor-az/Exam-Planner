package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Groupe;

import java.util.List;

public interface IGroupeService {

	public Groupe getGroupeById(Long id);

	public void addGroupe(Groupe pGroupe);

	public void updateGroupe(Groupe pGroupe);

	public void deleteGroupe(Long id);

	public List<Groupe> getGroupeByIds(List<Long> ids);

	public List<Groupe> getAllGroupes();
}
