package com.miracle.awt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.miracle.awt.dao.UserDAO;
import com.miracle.awt.model.Users;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserDAO userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		

		/*Here we are using dummy data, you need to load user data from
        database or other third party application*/
		//Users userFromDB = userDao.findByName(username);
		
		
		Users userFromDB  = new Users();
		
		userFromDB.setUsername("admin");
		userFromDB.setPassowrd("admin");
		userFromDB.setRole("admin");
		
		
		
		
		
		
		
		UserBuilder builder = null;
		if (userFromDB != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(new BCryptPasswordEncoder().encode(userFromDB.getPassword()));
			builder.roles(userFromDB.getRoles());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();
	}

}

