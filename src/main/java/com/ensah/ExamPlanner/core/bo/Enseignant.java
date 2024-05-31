package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("E")
public class Enseignant extends Personnel {

    @ManyToOne
    @JoinColumn(name = "id_filiere")
    private Filiere filiere;

    @ManyToOne
    @JoinColumn(name = "id_departement")
    private Departement departement;

    public Enseignant() {}

    public Enseignant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Enseignant(Long idEnseignant, String firstName, String lastName) {
        super(idEnseignant, firstName, lastName);
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

    @Override
    public String toString() {
        return "Enseignant{} " + super.toString();
    }
}
