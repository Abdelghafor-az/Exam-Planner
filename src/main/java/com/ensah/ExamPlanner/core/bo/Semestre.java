package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSemestre;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomSemestre;

    public Long getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Long idSemestre) {
        this.idSemestre = idSemestre;
    }

    public @NotBlank(message = "This field is required") String getNomSemestre() {
        return nomSemestre;
    }

    public void setNomSemestre(@NotBlank(message = "This field is required") String nomSemestre) {
        this.nomSemestre = nomSemestre;
    }
}
