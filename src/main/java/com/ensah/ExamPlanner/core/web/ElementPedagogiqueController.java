package com.ensah.ExamPlanner.core.web;

import com.ensah.ExamPlanner.core.bo.ElementPedagogique;
import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.services.*;
import com.ensah.ExamPlanner.core.web.models.ElementPedagogiqueModel;
import com.ensah.ExamPlanner.core.web.models.ExamenModel;
import com.ensah.ExamPlanner.core.web.models.PersonnelModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ElementPedagogiqueController {

	@Autowired
	private IElementPedagogiqueService epService;

	@Autowired
	private IEnseignantService enseignantService;

	@Autowired
	private INiveauService niveauService;

	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("/showElementForm", false);
	}

	@RequestMapping("showElementForm")
	public String showElementForm(Model model) {
		model.addAttribute("action", "addElement");
		model.addAttribute("elementModel", new ExamenModel());
		model.addAttribute("showElementForm", true);

		return "admin/form-pdg";
	}

	@PostMapping("/addElement")
	public String addElement(@Valid @ModelAttribute("elementModel") ElementPedagogiqueModel epModel,
							 BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("showElementForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
			return "admin/form-pdg";
		}

		ElementPedagogique elementPedagogique = new ElementPedagogique(
				epModel.getTitle(),
				enseignantService.getEnseignantById(epModel.getEnseignant()),
				enseignantService.getEnseignantById(epModel.getCoordonnateur()),
				niveauService.getNiveauById(epModel.getNiveau())
		);
		epService.addElementPedagogique(elementPedagogique);
		model.addAttribute("infoMsg", "Element Pedagogique ajouté avec succès");

		return "admin/form-pdg";
	}

	@GetMapping("/deleteElement/{idElement}")
	public String deletePersonnel(@PathVariable("idElement") Long idElement, Model model) {
		epService.deleteElementPedagogique(idElement);
		model.addAttribute("infoMsg", "Element Pedagogique supprimé avec succès");
		model.addAttribute("elementlList", epService.getAllElementPedagogiques());

		return "admin/form-pdg";
	}

	@GetMapping("/updateElement/{idElement}")
	public String updateElementForm(@PathVariable("idElement") Long idElement, Model model) {
		ElementPedagogique elementPedagogique = epService.getElementPedagogiqueById(idElement);
		// TODO: in the view, i need the id, title, enseignant(id+name), coordonnateur(id+name)
		model.addAttribute("elementModel", elementPedagogique);
		model.addAttribute("action", "updateElement");
		model.addAttribute("showElementForm", true);
		model.addAttribute("elementList", epService.getAllElementPedagogiques());

		return "admin/form-pdg";
	}

	@PostMapping("/updateElement")
	public String updateElement(@Valid @ModelAttribute("elementModel") ElementPedagogiqueModel epModel,
								BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			ElementPedagogique elementPedagogique = new ElementPedagogique(
					epModel.getIdElement(),
					epModel.getTitle(),
					enseignantService.getEnseignantById(epModel.getEnseignant()),
					enseignantService.getEnseignantById(epModel.getCoordonnateur()),
					niveauService.getNiveauById(epModel.getNiveau())
			);
			epService.updateElementPedagogique(elementPedagogique);
			model.addAttribute("infoMsg", "Enseignant modifié avec succès");
		}
		model.addAttribute("niveauList", niveauService.getAllNiveaus());
		model.addAttribute("elementList", epService.getAllElementPedagogiques());
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());

		return "admin/form-pdg";
	}

//	@PostMapping("/searchContact")
//	public String searchContact(@RequestParam("keyword") String keyword, Model model) {
//		model.addAttribute("contactList", contactService.searchContact(keyword));
//		return "form-pdg";
//	}

	@GetMapping("/allElements")
	public String allElements(Model model) {
		model.addAttribute("elementList", epService.getAllElementPedagogiques());

		return "admin/form-pdg";
	}
}
