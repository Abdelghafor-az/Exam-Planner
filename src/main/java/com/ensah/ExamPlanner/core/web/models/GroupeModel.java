package com.ensah.ExamPlanner.core.web.models;

import java.util.List;

public class GroupeModel {

    private String nomGroupe;

    private List<Long> enseignants;

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
