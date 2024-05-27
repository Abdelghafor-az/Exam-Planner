package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.Examen;
import com.ensah.ExamPlanner.core.dao.IExamenRepository;
import com.ensah.ExamPlanner.core.services.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExamenServiceImpl implements IExamenService {

	@Autowired
	private IExamenRepository examenDao;

	public List<Examen> getAllExamens() {
		return examenDao.findAll();
	}

	public void deleteExamen(Long id) {
		examenDao.deleteById(id);
	}

	public Examen getExamenById(Long id) {
		return examenDao.findById(id).get();
	}

	public void addExamen(Examen pExamen) {
		examenDao.save(pExamen);
	}

	public void updateExamen(Examen pExamen) {
		examenDao.save(pExamen);
	}
}
