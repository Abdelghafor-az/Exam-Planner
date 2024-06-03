package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Administrateur;
import com.ensah.ExamPlanner.core.bo.Enseignant;
import com.ensah.ExamPlanner.core.bo.Reservation;
import com.ensah.ExamPlanner.core.bo.Salle;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IReservationService {

	public Reservation getReservationById(Long id);

	public void addReservation(Reservation pReservation);

	public void updateReservation(Reservation pReservation);

	public void deleteReservation(Long id);

	public List<Reservation> getAllReservations();

	public List<Salle> getReservedSalles(LocalDate date, LocalTime heureDebut, LocalTime heureFin);

	public List<Salle> getAvailableSalles(LocalDate date, LocalTime heureDebut, LocalTime heureFin);

	public List<Enseignant> getReservedSupervisors(LocalDate date, LocalTime heureDebut, LocalTime heureFin);

	public List<Enseignant> getAvailableSupervisors(LocalDate date, LocalTime heureDebut, LocalTime heureFin);

	public List<Administrateur> getReservedAdmins(LocalDate date, LocalTime heureDebut, LocalTime heureFin);

	public List<Administrateur> getAvailableAdmins(LocalDate date, LocalTime heureDebut, LocalTime heureFin);
	}
