package com.insuranceapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
@Component
public class AppUserMapper {

	//convert app user to user details
	public AppUser convertToAppUser(UserDetails userDetails) {
		String username=userDetails.getUsername();
		String password=userDetails.getPassword();
		AppUser appUser=new AppUser();
		appUser.setUsername(username);
		appUser.setPassword(password);
		
		return appUser;
	}
	//from db to front end
    //convert user details to app user
	public UserDetails convertToUserDetails(AppUser appUser) {
		String userName=appUser.getUsername();
		String password=appUser.getPassword();
		List<GrantedAuthority> authorities=new ArrayList<>();
		
		//create roles for user
		List<String> roles=Arrays.asList("user","admin");
		for (String role : roles) {
			// add to the list of granted authority
			SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(role);
			//  add this to the list of granted authority
			authorities.add(simpleGrantedAuthority);
		}
		//CREATE A USERDETAILS OBJECT
		UserDetails details=new User(userName, password, authorities);
		return details;
	}
}
