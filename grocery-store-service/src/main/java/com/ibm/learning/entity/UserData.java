package com.ibm.learning.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class UserData {

	@Id
	private int id;
	private String username;
	private String password;

	public UserData() {
		super();
	}
	
	public UserData(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserData [username=" + username + ", password=" + password + "]";
	}
	
	
}
