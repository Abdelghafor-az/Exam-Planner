package com.ensah.ExamPlanner.core.web.controllers;

import com.ensah.ExamPlanner.core.bo.*;
import com.ensah.ExamPlanner.core.services.IElementPedagogiqueService;
import com.ensah.ExamPlanner.core.services.IExamenService;
import com.ensah.ExamPlanner.core.services.IReservationService;
import com.ensah.ExamPlanner.core.services.ISalleService;
import com.ensah.ExamPlanner.core.utils.DurationUtil;
import com.ensah.ExamPlanner.core.web.models.ExamenModel;
import com.ensah.ExamPlanner.core.web.models.ReservationModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Controller
@RequestMapping("/admin")
public class ExamenController {

	@Autowired
	private IExamenService examenService;

	@Autowired
	private IElementPedagogiqueService epService;

	@Autowired
	private IReservationService reservationService;

	@Autowired
	private ISalleService salleService;

	@ModelAttribute
	public void init(Model model) {

		model.addAttribute("/showExamenForm", false);
		model.addAttribute("/showExamenStage1", false);
		model.addAttribute("/showExamenStage2", false);
	}

	@RequestMapping("showExamenForm")
	public String showExamenForm(Model model) {
		model.addAttribute("action", "addExamenStage1");
		model.addAttribute("examenModel", new ExamenModel());
		model.addAttribute("showExamenForm", true);
		model.addAttribute("matiereList", epService.getAllElementPedagogiques());

		return "admin/form-exm";
	}

	/*
	@PostMapping("/addExamen")
	public String addExamen(@Valid @ModelAttribute("examenModel") ExamenModel examenModel,
							BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("showForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
			return "admin/form-exm";
		}
		Examen examen = new Examen(
		);
		examenService.addExamen(examen);
		model.addAttribute("infoMsg", "Enseignant ajouté avec succès");
		return "admin/form-exm";
	}
	 */

	@PostMapping("/addExamenStage1")
	public String addExamenStage1(@Valid @ModelAttribute("examenModel") ExamenModel examenModel,
							BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("examenModel", new ExamenModel());
			model.addAttribute("showExamenForm", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
			return "admin/form-exm";
		}
		ElementPedagogique matiere = epService.getElementPedagogiqueById(examenModel.getIdMatiere());
		Examen examen = new Examen(
				matiere,
				examenModel.getSemestre(),
				examenModel.getSession(),
				examenModel.getTypeExamen(),
				examenModel.getDateExamen(),
				examenModel.getHeureExamen(),
				getAnneUniversitaire(examenModel.getDateExamen())
		);
		examenService.addExamen(examen);

		examenModel.setIdExamen(examen.getIdExamen());
		System.out.println(examenModel);
		if (matiere.getType().equals("Module"))
			examenModel.setDureePrevue(2F);
		else
			examenModel.setDureePrevue(1.5F);
		model.addAttribute("examenModel", examenModel);
		model.addAttribute("action", "addExamenStage2");
		model.addAttribute("showDureePrevueForm", true);
		model.addAttribute("infoMsg", "Examen en phase 1");

		return "admin/form-exm";
	}

	@PostMapping("/addExamenStage2")
	public String addExamenStage2(@Valid @ModelAttribute("examenModel") ExamenModel examenModel,
							BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("examenModel", examenModel);
			model.addAttribute("showExamenStage1", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
			return "admin/form-exm";
		}
		System.out.println(examenModel);
		Examen examen = examenService.getExamenById(examenModel.getIdExamen());
		examen.setDureePrevue(DurationUtil.convertToDuration(examenModel.getDureePrevue()));
		examenService.updateExamen(examen);

		// Prepare a form for each salle
		int nombreSalle = examenModel.getNombreSalle();
		List<ReservationModel> reservationModels = new ArrayList<>(nombreSalle);
		for (int i = 0; i < nombreSalle; i++) {
			reservationModels.add(new ReservationModel());
		}
		examenModel.setReservations(reservationModels);

		List<Salle> availableSalles = reservationService.getAvailableSalles(
				examen.getDateExamen(),
				examen.getHeureExamen(),
				examen.getHeureExamen().plus(examen.getDureePrevue())
		);
		// TODO: you may need to set examen stage value for displaying purposes
		model.addAttribute("action", "addExamenStage3");
		model.addAttribute("examModel", examenModel);
		model.addAttribute("availableSalles", availableSalles);
		model.addAttribute("showSurveillanceForm", true);
		model.addAttribute("infoMsg", "Examen en phase 2");

		return "admin/form-exm";
	}

	@PostMapping("/addExamenStage3")
	public String addExamenStage3(@Valid @ModelAttribute("examenModel") ExamenModel examenModel,
							BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("examenModel", examenModel);
			model.addAttribute("showExamenStage2", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
			return "admin/form-exm";
		}

		// Manipulation des surveillances
		// TODO: you'll probably need to add additional classes for Emploi du temps
		Examen examen = examenService.getExamenById(examenModel.getIdExamen());
		LocalDate date = examen.getDateExamen();
		LocalTime heureDebut = examen.getHeureExamen();
		LocalTime heureFin = heureDebut.plus(examen.getDureePrevue());

		List<Enseignant> surveillants = reservationService.getAvailableSupervisors(date, heureDebut, heureFin);
		List<Administrateur> administrateurs = reservationService.getAvailableAdmins(date, heureDebut, heureFin);
		List<ReservationModel> reservationModels = examenModel.getReservations();
		int requiredSurveillantsCount = 0;
		int requiredControleursCount = reservationModels.toArray().length;
		assert reservationModels != null;
		for (ReservationModel rvm: reservationModels) {
			requiredSurveillantsCount += rvm.getNombreSurveillants();
		}

		int existingSurveillantsCount = surveillants.toArray().length;
		int existingControleursCount = surveillants.toArray().length;

		if (existingSurveillantsCount < requiredSurveillantsCount) {
			examenService.deleteExamen(examen.getIdExamen());
			model.addAttribute("message", "Insufficient Supervisors");
			return "error";
		}
		if (existingControleursCount < requiredControleursCount) {
			examenService.deleteExamen(examen.getIdExamen());
			model.addAttribute("message", "Insufficient Controllers");
			return "error";
		}

		// Pop items from an appropriate data structure
		Queue<Enseignant> surveillantsQueue = new LinkedList<>(surveillants);
		Queue<Administrateur> controleursQueue = new LinkedList<>(administrateurs);

		// Create Reservations
		List<Reservation> reservations = new ArrayList<>();
        for (ReservationModel rvm: reservationModels) {
			Reservation reservation = new Reservation();
			reservation.setSalle(salleService.getSalleByNomSalle(rvm.getNomSalle()));
			reservation.setDate(date);
			reservation.setHeureDebut(heureDebut);
			reservation.setHeureFin(heureFin);

			// Set Surveillants
			int nombreSurveillants = rvm.getNombreSurveillants();
			List<Enseignant> selectedSurveillants = new ArrayList<>();
			for (int i = 0; i < nombreSurveillants; i++) {
				selectedSurveillants.add(surveillantsQueue.poll());
			}
			reservation.setSupervisors(selectedSurveillants);

			// Set controleur
			Administrateur controleur = controleursQueue.poll();
			reservation.setControleur(controleur);

			reservations.add(reservation);
		}
		examen.setReservations(reservations);
		examenService.updateExamen(examen);

		model.addAttribute("examenList", examenService.getAllExamens());
		model.addAttribute("infoMsg", "Examen en phase 3");

		return "admin/form-exm";
	}


	@GetMapping("/updateExamen/{idExamen}")
	public String updateExamenForm(@PathVariable("idExamen") Long idExamen, Model model) {
		Examen examen = examenService.getExamenById(idExamen);
		model.addAttribute("examenModel", examen);
		model.addAttribute("action", "updateExamen");
		model.addAttribute("showUpdateExamenForm", true);
		model.addAttribute("examenList", examenService.getAllExamens());

		return "admin/form-exm";
	}

	@PostMapping("/updateExamen")
	public String updateExamen(@Valid @ModelAttribute("examenModel") ExamenModel examenModel,
								BindingResult bindingResult, Model model) {
		// Possible modifications: Duree Reelle, Epreuve, PV, Rapport
		if (bindingResult.hasErrors()) {
			model.addAttribute("showExamen", true);
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			Examen examen = examenService.getExamenById(examenModel.getIdExamen());
			examen.setDureeReelle(DurationUtil.convertToDuration(examenModel.getDureeReelle()));
			examen.setPv(examenModel.getPv());
			examen.setRapport(examenModel.getRapport());
			examen.setEpreuve(examenModel.getEpreuve());
			examenService.updateExamen(examen);
			model.addAttribute("infoMsg", "Examen modifié avec succès");
		}
		model.addAttribute("examenList", examenService.getAllExamens());

		return "admin/form-exm";
	}

	@GetMapping("/deleteExamen/{idExamen}")
	public String deletePersonnel(@PathVariable("idExamen") Long idExamen, Model model) {
		examenService.deleteExamen(idExamen);
		model.addAttribute("infoMsg", "Examen supprimé avec succès");
		model.addAttribute("examenlList", examenService.getAllExamens());

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

	private String getAnneUniversitaire(LocalDate date) {
		int month = date.getMonthValue();
		int year = date.getYear();

		if (month >= 9)
			return year + "/" + (year+1);
		else
			return (year-1) + "/" + year;
	}
}
