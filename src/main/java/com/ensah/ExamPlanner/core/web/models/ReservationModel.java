package com.ensah.ExamPlanner.core.web.models;

import java.util.List;

public class ReservationModel {

    private Integer nombreSurveillants;

    private String nomSalle;

    public ReservationModel() {}

    public ReservationModel(Integer nombreSurveillants, String nomSalle) {
        this.nombreSurveillants = nombreSurveillants;
        this.nomSalle = nomSalle;
    }

    public Integer getNombreSurveillants() {
        return nombreSurveillants;
    }

    public void setNombreSurveillants(Integer nombreSurveillants) {
        this.nombreSurveillants = nombreSurveillants;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }
}
