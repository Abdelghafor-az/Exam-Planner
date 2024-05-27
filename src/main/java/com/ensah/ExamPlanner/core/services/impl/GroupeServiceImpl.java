package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.Groupe;
import com.ensah.ExamPlanner.core.dao.IGroupeRepository;
import com.ensah.ExamPlanner.core.services.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupeServiceImpl implements IGroupeService {

	@Autowired
	private IGroupeRepository groupeDao;

	public List<Groupe> getAllGroupes() {
		return groupeDao.findAll();
	}

	public void deleteGroupe(Long id) {
		groupeDao.deleteById(id);
	}

	public Groupe getGroupeById(Long id) {
		return groupeDao.findById(id).get();
	}

	public void addGroupe(Groupe pGroupe) {
		groupeDao.save(pGroupe);
	}

	public void updateGroupe(Groupe pGroupe) {
		groupeDao.save(pGroupe);
	}
}
