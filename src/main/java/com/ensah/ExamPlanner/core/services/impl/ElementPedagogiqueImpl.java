package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.ElementPedagogique;
import com.ensah.ExamPlanner.core.dao.IElementPedagogiqueRepository;
import com.ensah.ExamPlanner.core.services.IElementPedagogiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ElementPedagogiqueImpl implements IElementPedagogiqueService {

	@Autowired
	private IElementPedagogiqueRepository elementPedagogiqueDao;

	public List<ElementPedagogique> getAllElementPedagogiques() {
		return elementPedagogiqueDao.findAll();
	}

	public void deleteElementPedagogique(Long id) {
		elementPedagogiqueDao.deleteById(id);
	}

	public ElementPedagogique getElementPedagogiqueById(Long id) {
		return elementPedagogiqueDao.findById(id).get();
	}

	public void addElementPedagogique(ElementPedagogique pElementPedagogique) {
		elementPedagogiqueDao.save(pElementPedagogique);
	}

	public void updateElementPedagogique(ElementPedagogique pElementPedagogique) {
		elementPedagogiqueDao.save(pElementPedagogique);
	}
}
