package com.ensah.ExamPlanner.core.web;

import com.ensah.ExamPlanner.core.bo.ElementPedagogique;
import com.ensah.ExamPlanner.core.services.*;
import com.ensah.ExamPlanner.core.web.models.ElementPedagogiqueModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
		model.addAttribute("elementModel", new ElementPedagogiqueModel());
		model.addAttribute("showElementForm", true);
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("elementList", epService.getAllElementPedagogiques());

		return "admin/form-pdg";
	}

	@PostMapping("/addElement")
	public String addElement(@Valid @ModelAttribute("elementModel") ElementPedagogiqueModel epModel,
							 BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("showElementForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
			model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
			model.addAttribute("elementList", epService.getAllElementPedagogiques());
			return "admin/form-pdg";
		}

		ElementPedagogique elementPedagogique = new ElementPedagogique(
				epModel.getTitre(),
				epModel.getType(),
				enseignantService.getEnseignantById(epModel.getEnseignant()),
				enseignantService.getEnseignantById(epModel.getCoordonnateur()),
				niveauService.getNiveauByNomNiveau(epModel.getNiveau())
		);
		System.out.println("-------------\n\n" +
				"\n" + epModel.getNiveau() +
				"\n" + niveauService.getNiveauByNomNiveau(epModel.getNiveau()) +
				"\n\n-----------------");
		epService.addElementPedagogique(elementPedagogique);
		model.addAttribute("infoMsg", "Element Pedagogique ajouté avec succès");
		model.addAttribute("elementList", epService.getAllElementPedagogiques());

		return "admin/form-pdg";
	}


	@GetMapping("/updateElement/{idElement}")
	public String updateElementForm(@PathVariable("idElement") Long idElement, Model model) {
		ElementPedagogique elementPedagogique = epService.getElementPedagogiqueById(idElement);
		// TODO: in the view, i need the id, title, enseignant(id+name), coordonnateur(id+name)
		ElementPedagogiqueModel elementPedagogiqueModel = new ElementPedagogiqueModel(
				elementPedagogique.getIdElementPedagogique(),
				elementPedagogique.getTitre(),
				elementPedagogique.getType(),
				elementPedagogique.getEnseignant().getIdPersonnel(),
				elementPedagogique.getCoordonnateur().getIdPersonnel(),
				elementPedagogique.getNiveau().getNomNiveau()
		);
		model.addAttribute("elementModel", elementPedagogiqueModel);
		model.addAttribute("action", "updateElement");
		model.addAttribute("showElementForm", true);
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("elementList", epService.getAllElementPedagogiques());

		return "admin/form-pdg";
	}

	@PostMapping("/updateElement")
	public String updateElement(@Valid @ModelAttribute("elementModel") ElementPedagogiqueModel epModel,
								BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("showElementForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			ElementPedagogique elementPedagogique = new ElementPedagogique(
					epModel.getIdElement(),
					epModel.getTitre(),
					epModel.getType(),
					enseignantService.getEnseignantById(epModel.getEnseignant()),
					enseignantService.getEnseignantById(epModel.getCoordonnateur()),
					niveauService.getNiveauByNomNiveau(epModel.getNiveau())
			);
			epService.updateElementPedagogique(elementPedagogique);
			model.addAttribute("infoMsg", "Enseignant modifié avec succès");
		}
		model.addAttribute("elementList", epService.getAllElementPedagogiques());
		// model.addAttribute("enseignantList", enseignantService.getAllEnseignants());

		return "admin/form-pdg";
	}

	@GetMapping("/deleteElement/{idElement}")
	public String deletePersonnel(@PathVariable("idElement") Long idElement, Model model) {
		epService.deleteElementPedagogique(idElement);
		model.addAttribute("infoMsg", "Element Pedagogique supprimé avec succès");
		model.addAttribute("elementList", epService.getAllElementPedagogiques());

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
