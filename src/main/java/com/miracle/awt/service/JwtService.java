package com.miracle.awt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
	
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;
	
	 public UserDetails loadUserByUsername(String userName) {
		 
		 return userDetailServiceImpl.loadUserByUsername(userName);

	 }

}
