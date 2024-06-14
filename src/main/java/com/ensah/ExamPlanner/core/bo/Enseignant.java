package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("E")
public class Enseignant extends Personnel {

//    @ManyToMany
//    @JoinTable(name = "filiere_enseignant",
//        joinColumns = @JoinColumn(name = "id_enseignant"),
//        inverseJoinColumns = @JoinColumn(name = "id_filiere")
//    )
//    private List<Filiere> filieres;

    @ManyToOne
    @JoinColumn(name = "id_filiere")
    private Filiere filiere;

    @ManyToOne
    @JoinColumn(name = "id_departement")
    private Departement departement;

    @OneToMany(cascade = {CascadeType.REMOVE})
    List<ElementPedagogique> elementPedagogiques;

    public Enseignant() {}

    public Enseignant(String nom, String prenom) {
        super(nom, prenom);
    }

    public Enseignant(Long idEnseignant, String firstName, String lastName) {
        super(idEnseignant, firstName, lastName);
    }


    public Enseignant(String nom, String prenom, Filiere filiere, Departement departement) {
        super(nom, prenom);
        this.filiere = filiere;
        this.departement = departement;
    }

    public Enseignant(Long idPersonnel, String nom, String prenom, Filiere filiere, Departement departement) {
        super(idPersonnel, nom, prenom);
        this.filiere = filiere;
        this.departement = departement;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<ElementPedagogique> getElementPedagogiques() {
        return elementPedagogiques;
    }

    public void setElementPedagogiques(List<ElementPedagogique> elementPedagogiques) {
        this.elementPedagogiques = elementPedagogiques;
    }

    @Override
    public String toString() {
        return "Enseignant{} " + super.toString();
    }
}
