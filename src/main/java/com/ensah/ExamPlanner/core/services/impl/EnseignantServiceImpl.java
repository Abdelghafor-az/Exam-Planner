package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.dao.IEnseignantRepository;
import com.ensah.ExamPlanner.core.services.IEnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnseignantServiceImpl implements IEnseignantService {

	@Autowired
	private IEnseignantRepository enseignantDao;

	public List<Enseignant> getAllEnseignants() {
		return enseignantDao.findAll();
	}

	public void deleteEnseignant(Long id) {
		enseignantDao.deleteById(id);
	}

	public Enseignant getEnseignantById(Long id) {
		return enseignantDao.findById(id).get();
	}

	public void addEnseignant(Enseignant pEnseignant) {
		enseignantDao.save(pEnseignant);
	}

	public void updateEnseignant(Enseignant pEnseignant) {
		enseignantDao.save(pEnseignant);
	}
}
