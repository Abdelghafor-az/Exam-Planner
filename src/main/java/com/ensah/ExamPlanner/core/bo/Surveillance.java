package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Surveillance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSurveillance;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomSurveillance;

    @OneToOne
    @JoinColumn(name = "id_salle_surveillance")
    private Salle salle;

    // personnel=(enseignant, administrateur)

    public Long getIdSurveillance() {
        return idSurveillance;
    }

    public void setIdSurveillance(Long idSurveillance) {
        this.idSurveillance = idSurveillance;
    }

    public String getNomSurveillance() {
        return nomSurveillance;
    }

    public void setNomSurveillance(String nomSurveillance) {
        this.nomSurveillance = nomSurveillance;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
