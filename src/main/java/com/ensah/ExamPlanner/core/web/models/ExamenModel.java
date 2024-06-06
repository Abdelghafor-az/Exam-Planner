package com.ensah.ExamPlanner.core.web.models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ExamenModel {

    private Long idExamen;

    private Long idMatiere;
    private String semestre;
    private String session;
    private String typeExamen;

    private LocalDate dateExamen;
    private LocalTime heureExamen;
    private Float dureePrevue;
    private Float dureeReelle;

    private Integer nombreSalle;
    private List<ReservationModel> reservations;

    private String epreuve;
    private String pv;
    private String rapport;

    public ExamenModel() {
    }

    public Long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
    }

    public Long getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Long idMatiere) {
        this.idMatiere = idMatiere;
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

    public Float getDureePrevue() {
        return dureePrevue;
    }

    public void setDureePrevue(Float dureePrevue) {
        this.dureePrevue = dureePrevue;
    }

    public Float getDureeReelle() {
        return dureeReelle;
    }

    public void setDureeReelle(Float dureeReelle) {
        this.dureeReelle = dureeReelle;
    }

    public Integer getNombreSalle() {
        return nombreSalle;
    }

    public void setNombreSalle(Integer nombreSalle) {
        this.nombreSalle = nombreSalle;
    }

    public List<ReservationModel> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationModel> reservations) {
        this.reservations = reservations;
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

    @Override
    public String toString() {
        return "ExamenModel{" +
                "idExamen=" + idExamen +
                ", idMatiere=" + idMatiere +
                ", semestre='" + semestre + '\'' +
                ", session='" + session + '\'' +
                ", typeExamen='" + typeExamen + '\'' +
                ", dateExamen=" + dateExamen +
                ", heureExamen=" + heureExamen +
                ", dureePrevue=" + dureePrevue +
                ", dureeReelle=" + dureeReelle +
                ", nombreSalle=" + nombreSalle +
                '}';
    }
}
