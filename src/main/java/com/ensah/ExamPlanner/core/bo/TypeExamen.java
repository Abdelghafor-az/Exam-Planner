package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public class TypeExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomTypeExamen;

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getNomTypeExamen() {
        return nomTypeExamen;
    }

    public void setNomTypeExamen(String nomTypeExamen) {
        this.nomTypeExamen = nomTypeExamen;
    }
}
