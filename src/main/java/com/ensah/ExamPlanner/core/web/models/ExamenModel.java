package com.ensah.ExamPlanner.core.web.models;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ExamenModel {

    private Long idExamen;

    private String nomExamen;

    private String semestre;

    private String session;

    private String typeExamen;

    private Date dateExamen;

    private Float dureePrevue;

    private Float dureeReelle;

    private List<Long> surveillances;

    private String pv;

    private String rapport;

    public ExamenModel() {}

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

    public List<Long> getSurveillances() {
        return surveillances;
    }

    public void setSurveillances(List<Long> surveillances) {
        this.surveillances = surveillances;
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
