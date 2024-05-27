package com.ensah.ExamPlanner.core.dao;

import com.ensah.ExamPlanner.core.bo.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccountDao extends JpaRepository<UserAccount, Long> {

	UserAccount getUserAccountByLogin(String username);
	
}
