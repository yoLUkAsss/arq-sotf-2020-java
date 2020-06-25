package com.coronavirus.insumos.users;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BasicUser {

	private String username;
	private String password;
	
	
	public BasicUser() {}
	
	
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
}
