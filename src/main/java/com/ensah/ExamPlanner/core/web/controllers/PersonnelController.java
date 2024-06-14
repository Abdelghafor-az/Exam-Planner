package com.ensah.ExamPlanner.core.web.controllers;

import com.ensah.ExamPlanner.core.bo.*;
import com.ensah.ExamPlanner.core.dao.IDepartementRepository;
import com.ensah.ExamPlanner.core.services.*;
import com.ensah.ExamPlanner.core.web.models.GroupeModel;
import com.ensah.ExamPlanner.core.web.models.PersonnelModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
//		model.addAttribute("departementList", enseignantService.getAllDepartements());
//		model.addAttribute("filiereList", enseignantService.getAllFilieres());
		model.addAttribute("showForm", true);
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("administrateurList", administrateurService.getAllAdministrateurs());

		return "admin/form";
	}

	// TODO: here also, use only addPersonnel methode and pass the type, the infoMsg attribute value can be parameterized.
	@PostMapping("/addPersonnel")
	public String addPersonnel(@Valid @ModelAttribute("personnelModel") PersonnelModel personnelModel,
							   BindingResult bindingResult, Model model) {
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

	// TODO: you can transfer that logic within that methode to service layer, move to updatePersonnel endpoint only
	@GetMapping("/updatePersonnel/{type}/{idPersonnel}")
	public String updatePersonnelForm(@PathVariable("idPersonnel") Long idPersonnel,
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

	// TODO: use only one endpoint named 'updatePersonnel' that take PersonnelModel as input, and pass the logic to the service (you will need to pass the type)
    // TODO: since you use personnel dao only for reading and you want to use it also for the update, consider removing other unused methods in the service layer
	@PostMapping("/updateEnseignant")
	public String updateEnseignat(@Valid @ModelAttribute("personnelModel") Enseignant enseignant,
								  BindingResult bindingResult, Model model) {
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

	@GetMapping("/deletePersonnel/{idPersonnel}")
	public String deletePersonnel(@PathVariable("idPersonnel") Long idPersonnel, Model model) {
		personnelService.deletePersonnel(idPersonnel);
		model.addAttribute("infoMsg", "Personnel supprimé avec succès");
		model.addAttribute("personnelList", personnelService.getAllPersonnels());

		return "admin/form";
	}

	@GetMapping("/allPersonnels")
	public String allPersonnels(Model model) {
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("administrateurList", administrateurService.getAllAdministrateurs());

		return "admin/form";
	}

	// TODO: do I need to pass group members? because i can access them
	@RequestMapping("showGroupeForm")
	public String showGroupeForm(Model model) {
		model.addAttribute("action", "addGroupe");
		model.addAttribute("groupeModel", new GroupeModel());
		model.addAttribute("showGroupeForm", true);

		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("groupeList", groupeService.getAllGroupes());

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

	@GetMapping("/updateGroupe/{idGroupe}")
	public String updateGroupeForm(@PathVariable("idGroupe") Long idGroupe, Model model) {
		Groupe groupe = groupeService.getGroupeById(idGroupe);

		// Get groupe members
		List<Long> groupeMembers = new ArrayList<>();
		groupe.getEnseignants().forEach(enseignant ->
				groupeMembers.add(enseignant.getIdPersonnel()));

		// prepare the dto
		GroupeModel groupeModel = new GroupeModel(
				groupe.getIdGroupe(),
				groupe.getNomGroupe(),
				groupeMembers
		);
		model.addAttribute("groupeModel", groupeModel);
		model.addAttribute("action", "updateGroupe");
		model.addAttribute("showGroupeForm", true);
//		model.addAttribute("groupeList", groupeService.getAllGroupes());
		// TODO: test also passing groupeMembers (List<Long>)
		initializeLists(model);

		return "admin/form";
	}

	@PostMapping("/updateGroupe")
	public String updateGroupe(@Valid @ModelAttribute("groupeModel") GroupeModel groupeModel,
							   BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("showGroupeForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			Groupe groupe = new Groupe(
					groupeModel.getIdGroupe(),
					groupeModel.getNomGroupe(),
					enseignantService.getEnseignantsByIds(groupeModel.getEnseignants())
			);
			groupeService.updateGroupe(groupe);
			model.addAttribute("infoMsg", "Groupe modifié avec succès");
		}
		initializeLists(model);

		return "admin/form";
	}

	@GetMapping("/deleteGroupe/{idGroupe}")
	public String deleteGroupe(@PathVariable("idGroupe") Long idGroupe, Model model) {
		groupeService.deleteGroupe(idGroupe);
		model.addAttribute("infoMsg", "Groupe supprimé avec succès");
		model.addAttribute("groupeList", groupeService.getAllGroupes());

		return "admin/form";
	}

//	@PostMapping("/searchContact")
//	public String searchContact(@RequestParam("keyword") String keyword, Model model) {
//		model.addAttribute("contactList", contactService.searchContact(keyword));
//		return "form";
//	}

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
