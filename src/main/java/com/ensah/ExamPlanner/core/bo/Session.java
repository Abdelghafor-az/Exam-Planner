package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSession;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String nomSession;

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }

    public String getNomSession() {
        return nomSession;
    }

    public void setNomSession(String nomSession) {
        this.nomSession = nomSession;
    }
}
