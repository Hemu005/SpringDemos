package com.insuranceapp.model;

import java.util.List;

public class AppUser {
////	private int userId;
//	private String username;
//	private String password;
////	private String email;
////	
////	private List<String> authorities;
//
//	public AppUser() {
//		
//	}
////	public AppUser(int userId, String userName, String password, String email, List<String> authorities) {
////		super();
////		this.userId = userId;
////		this.userName = userName;
////		this.password = password;
////		this.email = email;
////		this.authorities = authorities;
////	}
//	public AppUser(String username, String password) {
//		super();
////		this.userId = userId;
//		this.username = username;
//		this.password = password;
////		this.email = email;
////		this.authorities = authorities;
//	}
//
//	public String getUserName() {
//		return username;
//	}
//
//	public void setUserName(String username) {
//		this.username = username;
//	}
//
////	public int getUserId() {
////		return userId;
////	}
////
////	public void setUserId(int userId) {
////		this.userId = userId;
////	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
////	public String getEmail() {
////		return email;
////	}
////
////	public void setEmail(String email) {
////		this.email = email;
////	}
////
////	public List<String> getAuthorities() {
////		return authorities;
////	}
////
////	public void setAuthorities(List<String> authorities) {
////		this.authorities = authorities;
////	}
//
//	@Override
//	public String toString() {
////		return "AppUser [userName=" + userName + ", userId=" + userId + ", password=" + password + ", email=" + email
////				+ ", authorities=" + authorities + "]";
//		return "AppUser [username=" + username + ", password=" + password + "]";
//	}
//	
//	

	private String username;
	private String password;
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
		return "AppUser [username=" + username + ", password=" + password + "]";
	}
	
}
