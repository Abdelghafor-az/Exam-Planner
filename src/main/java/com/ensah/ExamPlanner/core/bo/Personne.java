package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonne;

	@NotBlank
	@Column(unique = true)
	private String username;

	@OneToOne(cascade = CascadeType.ALL, targetEntity = UserAccount.class)
	@JoinColumn(name = "id_compte_personne")
	private UserAccount compte;

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPerson) {
		this.idPersonne = idPerson;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserAccount getComptes() {
		return compte;
	}

	public void setComptes(UserAccount compte) {
		this.compte = compte;
	}
}