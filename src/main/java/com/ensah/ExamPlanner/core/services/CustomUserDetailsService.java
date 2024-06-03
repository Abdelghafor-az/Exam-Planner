package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.UserAccount;
import com.ensah.ExamPlanner.core.bo.UserPrincipal;
import com.ensah.ExamPlanner.core.dao.IUserAccountDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserAccountDao userAccountDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserAccount user = userAccountDao.getUserAccountByLogin(username);

		if (user == null) {
			throw new UsernameNotFoundException("Utilisateur introuvable par " + username);
		}

		if (user.getRole() == null) {
			throw new UsernameNotFoundException("Utilisateur sans droits d'accès");
		}

		return new UserPrincipal(user);
	}
}
