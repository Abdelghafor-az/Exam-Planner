package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalle;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomSalle;

    @Column(nullable = false)
    private Integer capacite;

    public Long getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Long idSalle) {
        this.idSalle = idSalle;
    }

    public @NotBlank(message = "This field is required") String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(@NotBlank(message = "This field is required") String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }
}
