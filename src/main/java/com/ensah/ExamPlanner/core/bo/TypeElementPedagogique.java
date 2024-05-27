package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class TypeElementPedagogique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomTypeElementPedagogique;

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getNomTypeElementPedagogique() {
        return nomTypeElementPedagogique;
    }

    public void setNomType(String nomType) {
        this.nomTypeElementPedagogique = nomType;
    }
}
