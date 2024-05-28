package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.Personne;
import com.ensah.ExamPlanner.core.dao.IPersonneRepository;
import com.ensah.ExamPlanner.core.services.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonneServiceImpl implements IPersonneService {

	@Autowired
	private IPersonneRepository personneDao;

	public Personne getPersonneById(Long id) {
		return personneDao.findById(id).get();
	}

	public List<Personne> getAllPersonnes() {
		return personneDao.findAll();
	}

	public void addPersonne(Personne pPersonne) {
		personneDao.save(pPersonne);
	}

	public void updatePersonne(Personne pPersonne) {
		personneDao.save(pPersonne);
	}

	public void deletePersonne(Long id) {
		personneDao.deleteById(id);
	}
}
