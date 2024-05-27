package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.ElementPedagogique;

import java.util.List;

public interface IElementPedagogiqueService {

	public ElementPedagogique getElementPedagogiqueById(Long id);

	public void addElementPedagogique(ElementPedagogique pElementPedagogique);

	public void updateElementPedagogique(ElementPedagogique pElementPedagogique);

	public void deleteElementPedagogique(Long id);

	public List<ElementPedagogique> getAllElementPedagogiques();
}
