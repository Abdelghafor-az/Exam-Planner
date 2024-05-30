package com.ensah.ExamPlanner.core.web;

import com.ensah.ExamPlanner.core.bo.Administrateur;
import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.bo.Groupe;
import com.ensah.ExamPlanner.core.bo.Personnel;
import com.ensah.ExamPlanner.core.services.*;
import com.ensah.ExamPlanner.core.web.models.GroupeModel;
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

	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("/showElementForm", false);
	}

	@RequestMapping("showElementForm")
	public String showElementForm(Model model) {
		model.addAttribute("action", "addPersonnel");
		model.addAttribute("personnelModel", new PersonnelModel());
		model.addAttribute("showForm", true);

		return "admin/form";
	}

	@PostMapping("/addElement")
	public String addElement(@Valid @ModelAttribute("personnelModel") PersonnelModel personnelModel, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
			return "admin/form";
		}

		Enseignant enseignant = new Enseignant(
				personnelModel.getNom(),
				personnelModel.getPrenom()
		);
//			enseignantService.addEnseignant(enseignant);
		model.addAttribute("infoMsg", "Enseignant ajouté avec succès");

		return "admin/form";
	}

	@GetMapping("/deleteElement/{idElement}")
	public String deletePersonnel(@PathVariable("idElement") Long idPersonnel, Model model) {
//		personnelService.deletePersonnel(idPersonnel);
		model.addAttribute("infoMsg", "Personnel supprimé avec succès");
		model.addAttribute("elementlList", epService.getAllElementPedagogiques());

		return "admin/form";
	}

	@GetMapping("/updateElement/{idElement}")
	public String updateElementForm(@PathVariable("idElement") Long idElement,
									  @PathVariable("type") Character type, Model model) {
//		Personnel personnel = personnelService.getPersonnelById(idPersonnel);
//		PersonnelModel personnelModel = new PersonnelModel(
//				personnel.getIdPersonnel(),
//				personnel.getNom(),
//				personnel.getPrenom(),
//				type == 'E' ? "Enseignant" : "Administrateur"
//		);
		if (type == 'E') {
			model.addAttribute("action", "updateEnseignant");
		} else if (type == 'A') {
			model.addAttribute("action", "updateAdministrateur");
		}
		model.addAttribute("showForm", true);
		model.addAttribute("elementList", epService.getAllElementPedagogiques());

		return "admin/form";
	}

	@PostMapping("/updateElement")
	public String updateElement(@Valid @ModelAttribute("personnelModel") Enseignant enseignant, BindingResult bindingResult,
								Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
//			enseignantService.updateEnseignant(enseignant);
			model.addAttribute("infoMsg", "Enseignant modifié avec succès");
		}
		model.addAttribute("elementList", epService.getAllElementPedagogiques());

		return "admin/form";
	}

//	@PostMapping("/searchContact")
//	public String searchContact(@RequestParam("keyword") String keyword, Model model) {
//		model.addAttribute("contactList", contactService.searchContact(keyword));
//		return "form";
//	}

	@GetMapping("/allElements")
	public String allElements(Model model) {
		model.addAttribute("elementList", epService.getAllElementPedagogiques());

		return "admin/form";
	}
}
