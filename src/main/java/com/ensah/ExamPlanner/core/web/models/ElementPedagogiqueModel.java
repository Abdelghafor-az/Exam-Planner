package com.ensah.ExamPlanner.core.web.models;

import jakarta.validation.constraints.NotBlank;

public class ElementPedagogiqueModel {

    private Long idElement;

    @NotBlank
    private String title;

    private Long enseignant;

    private Long coordonnateur;

    // todo: maybe String representing the name
    private Long niveau;

    public Long getIdElement() {
        return idElement;
    }

    public void setIdElement(Long idElement) {
        this.idElement = idElement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getNiveau() {
        return niveau;
    }

    public void setNiveau(Long niveau) {
        this.niveau = niveau;
    }
}
