package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiliere;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomFiliere;

//    @ManyToMany(mappedBy = "filieres")
    @OneToMany(mappedBy = "filiere")
    private List<Enseignant> enseignants;

    public Long getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Long idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nombreFiliere) {
        this.nomFiliere = nombreFiliere;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }
}
