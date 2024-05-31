package com.ensah.ExamPlanner.core.web;

import com.ensah.ExamPlanner.core.bo.ElementPedagogique;
import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.bo.Examen;
import com.ensah.ExamPlanner.core.services.IElementPedagogiqueService;
import com.ensah.ExamPlanner.core.services.IEnseignantService;
import com.ensah.ExamPlanner.core.services.IExamenService;
import com.ensah.ExamPlanner.core.services.INiveauService;
import com.ensah.ExamPlanner.core.web.models.ElementPedagogiqueModel;
import com.ensah.ExamPlanner.core.web.models.ExamenModel;
import com.ensah.ExamPlanner.core.web.models.PersonnelModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class ExamenController {

	@Autowired
	private IExamenService examenService;

	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("/showExamenForm", false);
	}

	@RequestMapping("showExamenForm")
	public String showExamenForm(Model model) {
		model.addAttribute("action", "addExamen");
		model.addAttribute("personnelModel", new ExamenModel());
		model.addAttribute("showExamenForm", true);

		return "admin/form-exm";
	}

	@PostMapping("/addExamen")
	public String addExamen(@Valid @ModelAttribute("examenModel") ExamenModel examenModel,
							BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
			return "admin/form-exm";
		}

		Examen examen = new Examen();
		examenService.addExamen(examen);
		model.addAttribute("infoMsg", "Enseignant ajouté avec succès");

		return "admin/form-exm";
	}

	@GetMapping("/deleteExamen/{idExamen}")
	public String deletePersonnel(@PathVariable("idExamen") Long idExamen, Model model) {
		examenService.deleteExamen(idExamen);
		model.addAttribute("infoMsg", "Examen supprimé avec succès");
		model.addAttribute("examenlList", examenService.getAllExamens());

		return "admin/form-exm";
	}

	@GetMapping("/updateExamen/{idExamen}")
	public String updateExamenForm(@PathVariable("idExamen") Long idExamen, Model model) {
		Examen examen = examenService.getExamenById(idExamen);
		model.addAttribute("examenModel", examen);
		model.addAttribute("action", "updateEnseignant");
		model.addAttribute("showExamenForm", true);
		model.addAttribute("examenList", examenService.getAllExamens());

		return "admin/form-exm";
	}

	@PostMapping("/updateExamen")
	public String updateExamen(@Valid @ModelAttribute("examenModel") ExamenModel examenModel,
								BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			Examen examen = new Examen();
//			ElementPedagogique elementPedagogique = new ElementPedagogique(
//					epModel.getIdElement(),
//					epModel.getTitle(),
//					enseignantService.getEnseignantById(epModel.getEnseignant()),
//					enseignantService.getEnseignantById(epModel.getCoordonnateur()),
//					niveauService.getNiveauById(epModel.getNiveau())
//			);
			examenService.updateExamen(examen);
			model.addAttribute("infoMsg", "Examen modifié avec succès");
		}
		model.addAttribute("examenList", examenService.getAllExamens());

		return "admin/form-exm";
	}

//	@PostMapping("/searchContact")
//	public String searchContact(@RequestParam("keyword") String keyword, Model model) {
//		model.addAttribute("contactList", contactService.searchContact(keyword));
//		return "form-exm";
//	}

	@GetMapping("/allExamens")
	public String allExamens(Model model) {
		model.addAttribute("examenList", examenService.getAllExamens());

		return "admin/form-exm";
	}
}
