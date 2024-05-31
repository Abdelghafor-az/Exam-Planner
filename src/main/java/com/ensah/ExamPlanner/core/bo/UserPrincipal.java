package com.ensah.ExamPlanner.core.bo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserPrincipal implements UserDetails {

	private UserAccount user;

	public UserPrincipal() {
		System.out.println("UserPrincipal est crée ...!");
	}

	@Override
	public String toString() {
		return "MyUserPrincipal [user=" + user + "]";
	}

	public UserPrincipal(UserAccount user) {
		this.user = user;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	// TODO : Cette méthode définie le role de l'utilisateur
	// si vous changer la conception de vos classe User/Role il faut la mettre à
	// jour
	// Les Role doivent être créer sous forme d'une collection de type
	// GrantedAuthority
	// Dans notre conception l'utilisateur a un et un seul role, ainsi il suffit de
	// créer
	// un objet de type GrantedAuthority avec le role définit par
	// user.getRole().getRoleName()
	// donc enfin la collection des roles de l'utilisateur contient un seul role
	// sous forme
	// de GrantedAuthority
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		ArrayList<GrantedAuthority> arrayAuths = new ArrayList<GrantedAuthority>();

		SimpleGrantedAuthority auth = new SimpleGrantedAuthority(user.getRole().getNomRole());
		arrayAuths.add(auth);
		return arrayAuths;
	}

	// TODO : les méthodes suivantes à adapter si vous changer la conception des
	// classes
	// Sinon vous pouvez les laisser telles quelles
	@Override
	public String getUsername() {
		return user.getProprietaire().getUsername();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	public String getLogin() {
		return user.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

}