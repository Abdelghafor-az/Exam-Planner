package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroupe;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomGroupe;

    @OneToMany
    private Set<Enseignant> enseignants;

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

    public Set<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }
}
