package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PERSONNEL_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
public class Personnel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonnel;

	@NotBlank
	private String nom;

	@NotBlank
	private String prenom;

	//	@OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL, targetEntity = UserAccount.class)
	//	private Set<UserAccount> comptes;

	public Personnel() {}

	public Personnel(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personnel(Long idPersonnel, String nom, String prenom) {
		this.idPersonnel = idPersonnel;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getIdPersonnel() {
		return idPersonnel;
	}

	public void setIdPersonnel(Long idPerson) {
		this.idPersonnel = idPerson;
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

	@Override
	public String toString() {
		return "Personnel{" +
				"idPersonnel=" + idPersonnel +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				'}';
	}
}
