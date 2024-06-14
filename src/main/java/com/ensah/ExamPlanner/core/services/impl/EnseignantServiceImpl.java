package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.Departement;
import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.bo.Filiere;
import com.ensah.ExamPlanner.core.dao.IDepartementRepository;
import com.ensah.ExamPlanner.core.dao.IEnseignantRepository;
import com.ensah.ExamPlanner.core.dao.IFiliereRepository;
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

	@Autowired
	private IFiliereRepository filiereDao;

	@Autowired
	private IDepartementRepository departementDao;

	public void addEnseignant(Enseignant pEnseignant) {
		enseignantDao.save(pEnseignant);
	}

	public void updateEnseignant(Enseignant pEnseignant) {
		enseignantDao.save(pEnseignant);
	}

	public void deleteEnseignant(Long id) {
		enseignantDao.deleteById(id);
	}

	public Enseignant getEnseignantById(Long id) {
		return enseignantDao.findById(id).get();
	}

	public List<Enseignant> getEnseignantsByIds(List<Long> ids) {
		return enseignantDao.findAllById(ids);
	}

	public List<Enseignant> getAllEnseignants() {
		return enseignantDao.findAll();
	}

	// Filiere methods
	public Filiere getFiliereById(Long id) {
		return filiereDao.findById(id).get();
	}

	public List<Filiere> getAllFilieres() {
		return filiereDao.findAll();
	}

	// Departement methods
	public Departement getDepartementById(Long id) {
		return departementDao.findById(id).get();
	}

	public List<Departement> getAllDepartements() {
		return departementDao.findAll();
	}
}
