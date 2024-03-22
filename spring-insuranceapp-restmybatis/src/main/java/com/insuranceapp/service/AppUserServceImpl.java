package com.insuranceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insuranceapp.model.AppUser;
import com.insuranceapp.model.AppUserMapper;
import com.insuranceapp.repository.IAppUserRepository;

@Service
@Transactional
public class AppUserServceImpl implements UserDetailsManager{

	@Autowired 
	private IAppUserRepository repository;
	
	@Autowired
	private AppUserMapper appUserMapper;
	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=repository.findByUsername(username);
        
		return null;
	}

	@Override
	public void createUser(UserDetails user) {
       AppUser 	appUser=appUserMapper.convertToAppUser(user);
       repository.addUser(appUser);
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
