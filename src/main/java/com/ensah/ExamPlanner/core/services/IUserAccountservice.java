package com.ensah.ExamPlanner.core.services;

import com.ensah.ExamPlanner.core.bo.Role;
import com.ensah.ExamPlanner.core.bo.UserAccount;

import java.util.List;

public interface IUserAccountservice {

	public List<Role> getAllRoles();

	public List<UserAccount> getAllAccounts();

	public UserAccount getAccountByUserName(String login);

	public UserAccount createUser(String login, Long idRole, Long idPerson) ;

}
