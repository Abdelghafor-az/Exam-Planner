package com.ensah.ExamPlanner.core.web.models;

import java.util.List;

public class GroupeModel {

    private Long idGroupe;

    private String nomGroupe;

    private List<Long> enseignants;

    public Long getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Long idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public List<Long> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Long> enseignants) {
        this.enseignants = enseignants;
    }
}
