package com.ensah.ExamPlanner.core.services.impl;

import com.ensah.ExamPlanner.core.bo.Administrateur;
import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.bo.Reservation;
import com.ensah.ExamPlanner.core.bo.Salle;
import com.ensah.ExamPlanner.core.dao.IReservationRepository;
import com.ensah.ExamPlanner.core.services.IAdministrateurService;
import com.ensah.ExamPlanner.core.services.IEnseignantService;
import com.ensah.ExamPlanner.core.services.IReservationService;
import com.ensah.ExamPlanner.core.services.ISalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationRepository reservationDao;

	@Autowired
	private ISalleService salleService;

	@Autowired
	private IEnseignantService enseignantService;

	@Autowired
	private IAdministrateurService administrateurService;

	public Reservation getReservationById(Long id) {
		return reservationDao.findById(id).get();
	}

	public void addReservation(Reservation pReservation) {
		reservationDao.save(pReservation);
	}

	public void updateReservation(Reservation pReservation) {
		reservationDao.save(pReservation);
	}

	public void deleteReservation(Long id) {
		reservationDao.deleteById(id);
	}

	public List<Reservation> getAllReservations() {
		return reservationDao.findAll();
	}

	public List<Salle> getReservedSalles(LocalDate date, LocalTime heureDebut, LocalTime heureFin) {
		return reservationDao.findReservedSalles(date, heureDebut, heureFin);
	}

	public List<Salle> getAvailableSalles(LocalDate date, LocalTime heureDebut, LocalTime heureFin) {
		List<Salle> reservedSalles = reservationDao.findReservedSalles(date, heureDebut, heureFin);
		List<Salle> allSalles = salleService.getAllSalles();

		return allSalles.stream()
				.filter(salle -> !reservedSalles.contains(salle))
				.collect(Collectors.toList());
	}

	public List<Enseignant> getReservedSupervisors(LocalDate date, LocalTime heureDebut, LocalTime heureFin) {
		return reservationDao.findReservedSupervisors(date, heureDebut, heureFin);
	}

	public List<Enseignant> getAvailableSupervisors(LocalDate date, LocalTime heureDebut, LocalTime heureFin) {
		List<Enseignant> reservedSupervisors = reservationDao.findReservedSupervisors(date, heureDebut, heureFin);
		List<Enseignant> allSupervisors = enseignantService.getAllEnseignants();

		return allSupervisors.stream()
				.filter(supervisor -> !reservedSupervisors.contains(supervisor))
				.collect(Collectors.toList());
	}

	public List<Administrateur> getReservedAdmins(LocalDate date, LocalTime heureDebut, LocalTime heureFin) {
		return reservationDao.findReservedControleurs(date, heureDebut, heureFin);
	}

	public List<Administrateur> getAvailableAdmins(LocalDate date, LocalTime heureDebut, LocalTime heureFin) {
		List<Administrateur> reservedAdmins = reservationDao.findReservedControleurs(date, heureDebut, heureFin);
		List<Administrateur> allAdmins = administrateurService.getAllAdministrateurs();

		return allAdmins.stream()
				.filter(admin -> !reservedAdmins.contains(admin))
				.collect(Collectors.toList());
	}
}
