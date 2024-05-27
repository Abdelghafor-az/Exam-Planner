package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiliere;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nombreFiliere;

    public Long getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Long idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getNombreFiliere() {
        return nombreFiliere;
    }

    public void setNombreFiliere(String nombreFiliere) {
        this.nombreFiliere = nombreFiliere;
    }
}
