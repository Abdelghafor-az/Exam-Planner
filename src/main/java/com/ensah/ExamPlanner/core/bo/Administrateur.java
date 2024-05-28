package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Administrateur extends Personnel {

//    private String type = "Administrateur";

    public Administrateur() {}

    public Administrateur(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public String toString() {
        return "Administrateur{} " + super.toString();
    }
}
