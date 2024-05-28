package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonne;

	private String nom;

	private String prenom;


	@OneToOne(cascade = CascadeType.ALL, targetEntity = UserAccount.class)
	@JoinColumn(name = "id_compte_personne")
	private UserAccount compte;

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPerson) {
		this.idPersonne = idPerson;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public UserAccount getComptes() {
		return compte;
	}

	public void setComptes(UserAccount compte) {
		this.compte = compte;
	}
}