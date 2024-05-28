package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.Personnel;
import com.ensah.ExamPlanner.core.dao.IPersonnelRepository;
import com.ensah.ExamPlanner.core.services.IPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonnelServiceImpl implements IPersonnelService {

	@Autowired
	private IPersonnelRepository personnelDao;

	public Personnel getPersonnelById(Long id) {
		return personnelDao.findById(id).get();
	}

	public List<Personnel> getAllPersonnels() {
		return personnelDao.findAll();
	}

	public void addPersonnel(Personnel pPersonnel) {
		personnelDao.save(pPersonnel);
	}

	public void updatePersonnel(Personnel pPersonnel) {
		personnelDao.save(pPersonnel);
	}

	public void deletePersonnel(Long id) {
		personnelDao.deleteById(id);
	}
}
