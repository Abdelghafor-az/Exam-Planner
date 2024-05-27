package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_personnel", discriminatorType = DiscriminatorType.CHAR)
public class Personnel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonnel;

	private String nom;

	private String prenom;

	//	@OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL, targetEntity = UserAccount.class)
	//	private Set<UserAccount> comptes;

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
}
