package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.Salle;
import com.ensah.ExamPlanner.core.dao.ISalleRepository;
import com.ensah.ExamPlanner.core.services.ISalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SalleServiceImpl implements ISalleService {

	@Autowired
	private ISalleRepository salleDao;

	public Salle getSalleById(Long id) {
		return salleDao.findById(id).get();
	}

	public Salle getSalleByNomSalle(String nomSalle) {
		return salleDao.getSalleByNomSalle(nomSalle);
	}

	public void addSalle(Salle pSalle) {
		salleDao.save(pSalle);
	}

	public void updateSalle(Salle pSalle) {
		salleDao.save(pSalle);
	}

	public void deleteSalle(Long id) {
		salleDao.deleteById(id);
	}

	public List<Salle> getAllSalles() {
		return salleDao.findAll();
	}

}
