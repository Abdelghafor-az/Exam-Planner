package com.ensah.ExamPlanner.core.web;

import com.ensah.ExamPlanner.core.bo.Administrateur;
import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.bo.Personnel;
import com.ensah.ExamPlanner.core.services.IPersonnelService;
import com.ensah.ExamPlanner.core.web.models.PersonnelModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ensah.ExamPlanner.core.services.IEnseignantService;
import com.ensah.ExamPlanner.core.services.IAdministrateurService;

@Controller
@RequestMapping("/admin")
public class PersonnelController {

	@Autowired
	private IEnseignantService enseignantService;

	@Autowired
	private IAdministrateurService administrateurService;

	@Autowired
	private IPersonnelService personnelService;

	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("/showForm", false);
	}

	@RequestMapping("showForm")
	public String showForm(Model model) {
		model.addAttribute("action", "addPersonnel");
		model.addAttribute("personnelModel", new Personnel());
		model.addAttribute("showForm", true);
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("administrateurList", administrateurService.getAllAdministrateurs());

		return "admin/form";
	}

	@PostMapping("/addPersonnel")
	public String addContact(@Valid @ModelAttribute("personnelModel") PersonnelModel personnelModel, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			if (personnelModel.getType() == "Enseignant") {
				Enseignant enseignant = new Enseignant();
				enseignant.setNom(personnelModel.getNom());
				enseignant.setPrenom(personnelModel.getPrenom());
				enseignantService.addEnseignant(enseignant);
				model.addAttribute("infoMsg", "Enseignant ajouté avec succès");
			}
			else if (personnelModel.getType() == "Administrateur") {
				Administrateur administrateur = new Administrateur();
				administrateur.setNom(personnelModel.getNom());
				administrateur.setPrenom(personnelModel.getPrenom());
				administrateurService.addAdministrateur(administrateur);
				model.addAttribute("infoMsg", "Administrateur ajouté avec succès");
			}
		}
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("administrateurList", administrateurService.getAllAdministrateurs());

		return "admin/form";
	}

	@GetMapping("/deletePersonnel/{idPersonnel}")
	public String deleteContact(@PathVariable("idPersonnel") Long idPersonnel, Model model) {
		personnelService.deletePersonnel(idPersonnel);
		model.addAttribute("infoMsg", "Personnel supprimé avec succès");
		model.addAttribute("personnelList", personnelService.getAllPersonnels());

		return "admin/form";
	}

	@GetMapping("/updatePersonnel/{type}/{idPersonnel}")
	public String updateContactForm(@PathVariable("idPersonnel") Long idPersonnel,
									@PathVariable("type") Character type, Model model) {
		Personnel personnel = personnelService.getPersonnelById(idPersonnel);
		model.addAttribute("personnelModel", personnel);
		if (type == 'E') {
			model.addAttribute("action", "updateEnseignant");
		} else if (type == 'A') {
			model.addAttribute("action", "updateAdministrateur");
		}
		model.addAttribute("showForm", true);
		model.addAttribute("personnelList", personnelService.getAllPersonnels());

		return "admin/form";
	}

	/*
	@PostMapping("/updatePersonnel")
	public String updatePersonnel(@Valid @ModelAttribute("personnelModel") Personnel personnel, BindingResult bindingResult,
			Model model) {

		System.out.println(personnel);
		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			personnelService.updatePersonnel(personnel);
			model.addAttribute("infoMsg", "Personnel modifié avec succès");
		}
		model.addAttribute("personnelList", personnelService.getAllPersonnels());

		return "admin/form";
	}
	*/

	@PostMapping("/updateEnseignant")
	public String updateEnseignat(@Valid @ModelAttribute("personnelModel") Enseignant enseignant, BindingResult bindingResult,
								Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			enseignantService.updateEnseignant(enseignant);
			model.addAttribute("infoMsg", "Enseignant modifié avec succès");
		}
		// model.addAttribute("personnelList", personnelService.getAllPersonnels());
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("administrateurList", administrateurService.getAllAdministrateurs());

		return "admin/form";
	}

	@PostMapping("/updateAdministrateur")
	public String updateAdministrateur(@Valid @ModelAttribute("administrateurModel") Administrateur administrateur, BindingResult bindingResult,
								Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			administrateurService.updateAdministrateur(administrateur);
			model.addAttribute("infoMsg", "Administrateur modifié avec succès");
		}
		//model.addAttribute("personnelList", personnelService.getAllPersonnels());
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("administrateurList", administrateurService.getAllAdministrateurs());

		return "admin/form";
	}

//	@PostMapping("/serachContact")
//	public String serachContact(@RequestParam("keyword") String keyword, Model model) {
//		model.addAttribute("contactList", contactService.searchContact(keyword));
//		return "form";
//	}

	@GetMapping("/allPersonnels")
	public String allPersonnels(Model model) {
		// model.addAttribute("personnelList", personnelService.getAllPersonnels());
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("administrateurList", administrateurService.getAllAdministrateurs());

		return "admin/form";
	}
}
