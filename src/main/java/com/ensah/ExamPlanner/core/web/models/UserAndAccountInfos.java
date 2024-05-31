package com.ensah.ExamPlanner.core.web.models;

public class UserAndAccountInfos {

	private Long idPersonne;

	private Long idCompte;

	private String login;

	private String username;

	public UserAndAccountInfos() {
	}


	public UserAndAccountInfos(Long idPersonne, Long idCompte, String login, String username) {
		this.idPersonne = idPersonne;
		this.idCompte = idCompte;
		this.login = login;
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserAndAccountInfos [idPersonne=" + idPersonne + ", idCompte=" + idCompte + ", login=" + login
				+ ", username=" + username + "]";
	}

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
