package com.ibm.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.learning.entity.UserData;

public interface UserRepository extends JpaRepository<UserData, Integer> {

	UserData findByUsername(String username);
	
	UserData findByUsernameAndPassword(String username, String password);
}
