package com.miracle.awt.repo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.miracle.awt.model.Users;


public interface UserRepo extends JpaRepository<Users, String>{
	
	@Query("select u from USERS u where u.username = ?1")
	public Users findByUsername(String username);

}
