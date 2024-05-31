package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Niveau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveau;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomNiveau;

    public Long getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Long idNiveau) {
        this.idNiveau = idNiveau;
    }

    public String getNomNiveau() {
        return nomNiveau;
    }

    public void setNomNiveau(String nomNiveau) {
        this.nomNiveau = nomNiveau;
    }

    @Override
    public String toString() {
        return "Niveau{" +
                "idNiveau=" + idNiveau +
                ", nomNiveau='" + nomNiveau + '\'' +
                '}';
    }
}
