package com.ensah.ExamPlanner.core.web.models;

import jakarta.validation.constraints.NotBlank;

public class ElementPedagogiqueModel {

    private Long idElement;

    @NotBlank
    private String titre;

    private String type;

    private Long enseignant;

    private Long coordonnateur;

    // todo: maybe String representing the name
    private String niveau;

    public ElementPedagogiqueModel() {}

    public ElementPedagogiqueModel(Long idElement, String titre, String type, Long enseignant, Long coordonnateur, String niveau) {
        this.idElement = idElement;
        this.titre = titre;
        this.type = type;
        this.enseignant = enseignant;
        this.coordonnateur = coordonnateur;
        this.niveau = niveau;
    }

    public Long getIdElement() {
        return idElement;
    }

    public void setIdElement(Long idElement) {
        this.idElement = idElement;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Long enseignants) {
        this.enseignant = enseignants;
    }

    public Long getCoordonnateur() {
        return coordonnateur;
    }

    public void setCoordonnateur(Long coordonnateur) {
        this.coordonnateur = coordonnateur;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
