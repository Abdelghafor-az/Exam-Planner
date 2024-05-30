package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroupe;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomGroupe;

     @OneToMany
     @JoinColumn(name = "id_groupe")
//    @ManyToMany
//    @JoinTable(
//            name = "groupe_enseignant",
//            joinColumns = @JoinColumn(name = "groupe_id"),
//            inverseJoinColumns = @JoinColumn(name = "enseignant_id")
//    )
    private List<Enseignant> enseignants;

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

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }
}
