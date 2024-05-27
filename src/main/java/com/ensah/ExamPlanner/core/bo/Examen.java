package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.Duration;
import java.util.Date;

@Entity
public class Examen {
    // TODO: choose carefully the attributes that should be persisted, and those that should not.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExamen;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomExamen;

    private String semestre;

    private String session;

    private String typeExamen;

    private Date dateExamen;

    private Duration dureePrevue;

    private Duration dureeReelle;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_examen_surveillance")
    private Surveillance surveillance;

    @Transient
    private String AnneUniversitaire;

    private String pv;

    private String rapport;

    public Long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
    }

    public String getNomExamen() {
        return nomExamen;
    }

    public void setNomExamen(String nomExamen) {
        this.nomExamen = nomExamen;
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

    public Date getDateExamen() {
        return dateExamen;
    }

    public void setDateExamen(Date dateExamen) {
        this.dateExamen = dateExamen;
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

    public Surveillance getSurveillance() {
        return surveillance;
    }

    public void setSurveillance(Surveillance surveillance) {
        this.surveillance = surveillance;
    }

    public String getAnneUniversitaire() {
        return AnneUniversitaire;
    }

    public void setAnneUniversitaire(String anneUniversitaire) {
        AnneUniversitaire = anneUniversitaire;
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
