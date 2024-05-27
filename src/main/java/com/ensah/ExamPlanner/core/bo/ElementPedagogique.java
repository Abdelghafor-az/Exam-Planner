package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ElementPedagogique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElementPedagogique;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String titre;
}
