package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_examen")
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "id_salle", nullable = false)
    private Salle salle;

    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;

    @ManyToMany
    @JoinTable(
            name = "reservation_supervisors",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "supervisor_id")
    )
    private List<Enseignant> supervisors;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Administrateur controleur;

    public Reservation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public List<Enseignant> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(List<Enseignant> supervisors) {
        this.supervisors = supervisors;
    }

    public Administrateur getControleur() {
        return controleur;
    }

    public void setControleur(Administrateur controleur) {
        this.controleur = controleur;
    }
}

