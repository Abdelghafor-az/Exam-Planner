package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.Filiere;
import com.ensah.ExamPlanner.core.dao.IFiliereRepository;
import com.ensah.ExamPlanner.core.services.IFiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FiliereServiceImpl implements IFiliereService {

	@Autowired
	private IFiliereRepository filiereDao;

	public Filiere getFiliereById(Long id) {
		return filiereDao.findById(id).get();
	}

	public List<Filiere> getAllFilieres() {
		return filiereDao.findAll();
	}
}
