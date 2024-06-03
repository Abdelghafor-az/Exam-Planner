package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Surveillance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSurveillance;

    @OneToOne
    @JoinColumn(name = "id_salle_surveillance")
    private Salle salle;


    public Long getIdSurveillance() {
        return idSurveillance;
    }

    public void setIdSurveillance(Long idSurveillance) {
        this.idSurveillance = idSurveillance;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
