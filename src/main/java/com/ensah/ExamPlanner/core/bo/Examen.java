package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Examen {
    // TODO: choose carefully the attributes that should be persisted, and those that should not.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExamen;

    private Stage stage;

    // @NotBlank(message = "This field is required")
    //@Column(unique = true, nullable = false)
    @ManyToOne
    @JoinColumn(name = "id_matiere")
    private ElementPedagogique matiere;

    private String semestre;

    private String session;

    private String typeExamen;

    private LocalDate dateExamen;

    private LocalTime heureExamen;

    private Duration dureePrevue;

    private Duration dureeReelle;

    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_examen")
    private List<Surveillance> surveillances;
     */

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    //@Transient
    private String AnneUniversitaire;

    private String epreuve;

    private String pv;

    private String rapport = "Rien à signaler";

    public Examen() {}

    public Examen(ElementPedagogique matiere, String semestre, String session, String typeExamen, LocalDate dateExamen, LocalTime heureExamen, String anneUniversitaire) {
        this.matiere = matiere;
        this.semestre = semestre;
        this.session = session;
        this.typeExamen = typeExamen;
        this.dateExamen = dateExamen;
        this.heureExamen = heureExamen;
        this.AnneUniversitaire = anneUniversitaire;
    }

    public Long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ElementPedagogique getMatiere() {
        return matiere;
    }

    public void setMatiere(ElementPedagogique matiere) {
        this.matiere = matiere;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getTypeExamen() {
        return typeExamen;
    }

    public void setTypeExamen(String typeExamen) {
        this.typeExamen = typeExamen;
    }

    public LocalDate getDateExamen() {
        return dateExamen;
    }

    public void setDateExamen(LocalDate dateExamen) {
        this.dateExamen = dateExamen;
    }

    public LocalTime getHeureExamen() {
        return heureExamen;
    }

    public void setHeureExamen(LocalTime heureExamen) {
        this.heureExamen = heureExamen;
    }

    public Duration getDureePrevue() {
        return dureePrevue;
    }

    public void setDureePrevue(Duration dureePrevue) {
        this.dureePrevue = dureePrevue;
    }

    public Duration getDureeReelle() {
        return dureeReelle;
    }

    public void setDureeReelle(Duration dureeReelle) {
        this.dureeReelle = dureeReelle;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getAnneUniversitaire() {
        return AnneUniversitaire;
    }

    public void setAnneUniversitaire(String anneUniversitaire) {
        AnneUniversitaire = anneUniversitaire;
    }

    public String getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(String epreuve) {
        this.epreuve = epreuve;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }
}
