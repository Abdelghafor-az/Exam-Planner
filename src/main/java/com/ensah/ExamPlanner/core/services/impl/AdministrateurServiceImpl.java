package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.Administrateur;
import com.ensah.ExamPlanner.core.dao.IAdministrateurRepository;
import com.ensah.ExamPlanner.core.services.IAdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdministrateurServiceImpl implements IAdministrateurService {

	@Autowired
	private IAdministrateurRepository administrateurDao;

	public Administrateur getAdministrateurById(Long id) {
		return administrateurDao.findById(id).get();
	}

	public List<Administrateur> getAllAdministrateurs() {
		return administrateurDao.findAll();
	}

	public void addAdministrateur(Administrateur pAdministrateur) {
		administrateurDao.save(pAdministrateur);
	}

	public void updateAdministrateur(Administrateur pAdministrateur) {
		administrateurDao.save(pAdministrateur);
	}

	public void deleteAdministrateur(Long id) {
		administrateurDao.deleteById(id);
	}
}
