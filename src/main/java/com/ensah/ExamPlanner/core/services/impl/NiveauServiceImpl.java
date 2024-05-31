package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.Niveau;
import com.ensah.ExamPlanner.core.dao.INiveauRepository;
import com.ensah.ExamPlanner.core.services.INiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NiveauServiceImpl implements INiveauService {

	@Autowired
	private INiveauRepository niveauDao;

	public List<Niveau> getAllNiveaus() {
		return niveauDao.findAll();
	}

	public void deleteNiveau(Long id) {
		niveauDao.deleteById(id);
	}

	public Niveau getNiveauById(Long id) {
		return niveauDao.findById(id).get();
	}

	public void addNiveau(Niveau pNiveau) {
		niveauDao.save(pNiveau);
	}

	public void updateNiveau(Niveau pNiveau) {
		niveauDao.save(pNiveau);
	}
}
