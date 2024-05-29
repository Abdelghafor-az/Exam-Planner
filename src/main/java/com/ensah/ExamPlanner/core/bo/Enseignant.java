package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("E")
public class Enseignant extends Personnel {

//    private String type = "Enseignant";

    public Enseignant() {}

    public Enseignant(String firstName, String lastName) {
        super(firstName, lastName);
    }

//    public Enseignant(Long idEnseignant, String firstName, String lastName) {
//        super(idEnseignant, firstName, lastName);
//    }

    @Override
    public String toString() {
        return "Enseignant{} " + super.toString();
    }
}
