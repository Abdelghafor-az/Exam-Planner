package com.ensah.ExamPlanner.core.web.models;


import com.ensah.ExamPlanner.core.bo.Departement;
import com.ensah.ExamPlanner.core.bo.Filiere;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PersonnelModel {

    private Long idPersonnel;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @Pattern(regexp = "^Enseignant$|^Administrateur$",
            message = "accept only 'Enseignant' or 'Administrateur' roles.")
    private String type;

    private Departement departement;

    private Filiere filiere;

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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
