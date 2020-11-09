package com.ibm.learning.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibm.learning.entity.UserData;
import com.ibm.learning.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { if ("javainuse".equals(username)) { return new
	 * User("javainuse",
	 * "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new
	 * ArrayList<>()); } else { throw new
	 * UsernameNotFoundException("User not found with username: " + username); } }
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserData userData = userRepo.findByUsername(username);
		if(userData != null) {
			return new User(userData.getUsername(), userData.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User Name or Password is invalid");
		}
	}
	
	public UserDetails loadUser(String username, String password) throws UsernameNotFoundException {
		UserData userData = userRepo.findByUsernameAndPassword(username, password);
		if(userData != null) {
			return new User(userData.getUsername(), userData.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User Name or Password is invalid");
		}
	}

}