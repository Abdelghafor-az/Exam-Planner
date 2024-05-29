package com.ensah.ExamPlanner.core.web.models;


public class PersonnelModel {

    private Long idPersonnel;

    private String nom;

    private String prenom;

    private String type;

    public PersonnelModel() {}

    public PersonnelModel (Long idPersonnel, String nom, String prenom, String type) {
        this.idPersonnel = idPersonnel;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }

    public Long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(Long id) {
        this.idPersonnel = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
