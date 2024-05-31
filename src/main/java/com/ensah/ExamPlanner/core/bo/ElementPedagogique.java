package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class ElementPedagogique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElementPedagogique;

    @NotBlank(message = "This field is required")
    @Column(unique = true, nullable = false)
    private String titre;

    @NotBlank(message = "type: Element OR Module")
    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "id_enseignant")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "id_coordonnateur")
    private Enseignant coordonnateur;

    @ManyToOne
    @JoinColumn(name = "id_niveau")
    private Niveau niveau;

    public ElementPedagogique() {}

    // For addition (ID to be generated)
    public ElementPedagogique(String titre, String type, Enseignant enseignant, Enseignant coordonnateur, Niveau niveau) {
        this.titre = titre;
        this.type = type;
        this.enseignant = enseignant;
        this.coordonnateur = coordonnateur;
        this.niveau = niveau;
    }

    // For update
    public ElementPedagogique(Long idElementPedagogique, String type, String titre, Enseignant enseignant, Enseignant coordonnateur, Niveau niveau) {
        this.idElementPedagogique = idElementPedagogique;
        this.titre = titre;
        this.type = type;
        this.enseignant = enseignant;
        this.coordonnateur = coordonnateur;
        this.niveau = niveau;
    }

    public Long getIdElementPedagogique() {
        return idElementPedagogique;
    }

    public void setIdElementPedagogique(Long idElementPedagogique) {
        this.idElementPedagogique = idElementPedagogique;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Enseignant getCoordonnateur() {
        return coordonnateur;
    }

    public void setCoordonnateur(Enseignant coordonnateur) {
        this.coordonnateur = coordonnateur;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
