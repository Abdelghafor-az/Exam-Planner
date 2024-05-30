package com.ensah.ExamPlanner.core.web;

import com.ensah.ExamPlanner.core.bo.Administrateur;
import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.bo.Groupe;
import com.ensah.ExamPlanner.core.bo.Personnel;
import com.ensah.ExamPlanner.core.services.IGroupeService;
import com.ensah.ExamPlanner.core.services.IPersonnelService;
import com.ensah.ExamPlanner.core.web.models.GroupeModel;
import com.ensah.ExamPlanner.core.web.models.PersonnelModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ensah.ExamPlanner.core.services.IEnseignantService;
import com.ensah.ExamPlanner.core.services.IAdministrateurService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class PersonnelController {

	@Autowired
	private IPersonnelService personnelService;

	@Autowired
	private IEnseignantService enseignantService;

	@Autowired
	private IAdministrateurService administrateurService;

	@Autowired
	private IGroupeService groupeService;

	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("/showForm", false);
		model.addAttribute("/showGroupeForm", false);
	}

	@RequestMapping("showForm")
	public String showForm(Model model) {
		model.addAttribute("action", "addPersonnel");
		model.addAttribute("personnelModel", new PersonnelModel());
		model.addAttribute("showForm", true);
		// model.addAttribute("showGroupeForm", true);
		initializeLists(model);

		return "admin/form";
	}

	@RequestMapping("showGroupeForm")
	public String showGroupeForm(Model model) {
		model.addAttribute("action", "addGroupe");
		model.addAttribute("groupeModel", new GroupeModel());
		// model.addAttribute("showForm", false);
		model.addAttribute("showGroupeForm", true);
		initializeLists(model);

		return "admin/form";
	}

	@PostMapping("/addPersonnel")
	public String addPersonnel(@Valid @ModelAttribute("personnelModel") PersonnelModel personnelModel, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
			return "admin/form";
		}

		if (personnelModel.getType().equals("Enseignant")) {
			Enseignant enseignant = new Enseignant(
					personnelModel.getNom(),
					personnelModel.getPrenom()
			);
			enseignantService.addEnseignant(enseignant);
			model.addAttribute("infoMsg", "Enseignant ajouté avec succès");
		}
		else if (personnelModel.getType().equals("Administrateur")) {
			Administrateur administrateur = new Administrateur(
					personnelModel.getNom(),
					personnelModel.getPrenom()
			);
			administrateurService.addAdministrateur(administrateur);
			model.addAttribute("infoMsg", "Administrateur ajouté avec succès");
		}
		initializeLists(model);

		return "admin/form";
	}

	@PostMapping("/addGroupe")
	public String addGroupe(@Valid @ModelAttribute("groupeModel") GroupeModel groupeModel, BindingResult bindingResult,
							Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
			return "admin/form";
		}

		Groupe groupe = new Groupe();
		groupe.setNomGroupe(groupeModel.getNomGroupe());

		List<Enseignant> selectedEnseignants = enseignantService.getEnseignantsByIds(groupeModel.getEnseignants());
		groupe.setEnseignants(selectedEnseignants);

		groupeService.addGroupe(groupe);

		initializeLists(model);

		return "admin/form";
	}

	@GetMapping("/deletePersonnel/{idPersonnel}")
	public String deletePersonnel(@PathVariable("idPersonnel") Long idPersonnel, Model model) {
		personnelService.deletePersonnel(idPersonnel);
		model.addAttribute("infoMsg", "Personnel supprimé avec succès");
		model.addAttribute("personnelList", personnelService.getAllPersonnels());

		return "admin/form";
	}

	@GetMapping("/deleteGroupe/{idGroupe}")
	public String deleteGroupe(@PathVariable("idGroupe") Long idGroupe, Model model) {
		groupeService.deleteGroupe(idGroupe);
		model.addAttribute("infoMsg", "Groupe supprimé avec succès");
		model.addAttribute("groupeList", groupeService.getAllGroupes());

		return "admin/form";
	}

	@GetMapping("/updatePersonnel/{type}/{idPersonnel}")
	public String updatePersonnelForm(@PathVariable("idPersonnel") Long idPersonnel,
									  @PathVariable("type") Character type, Model model) {
		Personnel personnel = personnelService.getPersonnelById(idPersonnel);
		PersonnelModel personnelModel = new PersonnelModel(
				personnel.getIdPersonnel(),
				personnel.getNom(),
				personnel.getPrenom(),
				type == 'E' ? "Enseignant" : "Administrateur"
		);
		model.addAttribute("personnelModel", personnelModel);
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
		initializeLists(model);

		return "admin/form";
	}

//	@PostMapping("/searchContact")
//	public String searchContact(@RequestParam("keyword") String keyword, Model model) {
//		model.addAttribute("contactList", contactService.searchContact(keyword));
//		return "form";
//	}

	@GetMapping("/allPersonnels")
	public String allPersonnels(Model model) {
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("administrateurList", administrateurService.getAllAdministrateurs());

		return "admin/form";
	}

	@GetMapping("/allGroupes")
	public String allGroupes(Model model) {
		model.addAttribute("groupeList", groupeService.getAllGroupes());

		return "admin/form";
	}

	private void initializeLists(Model model) {
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("administrateurList", administrateurService.getAllAdministrateurs());
		model.addAttribute("groupeList", groupeService.getAllGroupes());
	}
}
