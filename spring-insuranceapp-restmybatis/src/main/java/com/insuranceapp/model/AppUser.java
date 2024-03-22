package com.insuranceapp.model;

import java.util.List;

public class AppUser {
	private int userId;
	private String userName;
	private String password;
	private String email;
	
	private List<String> authorities;

	public AppUser() {
		
	}
	public AppUser(int userId, String userName, String password, String email, List<String> authorities) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "AppUser [userName=" + userName + ", userId=" + userId + ", password=" + password + ", email=" + email
				+ ", authorities=" + authorities + "]";
	}
	
	
}
