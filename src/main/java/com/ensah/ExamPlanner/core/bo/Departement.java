package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartement;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomDepartement;

    public Long getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Long idDepartement) {
        this.idDepartement = idDepartement;
    }

    public @NotBlank(message = "This field is required") String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(@NotBlank(message = "This field is required") String nombreDepartement) {
        this.nomDepartement = nombreDepartement;
    }
}
