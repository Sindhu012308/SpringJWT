package com.miracle.awt.controller;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.awt.model.JwtRequest;
import com.miracle.awt.model.JwtResponse;
import com.miracle.awt.service.JwtService;
import com.miracle.awt.util.JWTUtility;

@RestController
public class JWTController {

	@Autowired
	JwtService jwtService;	

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtility jwtTokenUtil;

	
	@RequestMapping(value="/login")
	public String login(){
		
		//Here I redirect to facebook
		
		return "";
		
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = jwtService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails); 
		
		String[] roles  = new String[]{userDetails.getAuthorities().toString()};
		
		//roles = userDetails.getAuthorities().toArray(roles);
		
		
	
		return ResponseEntity.ok(new JwtResponse(token, roles));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
	@RequestMapping(value = "/anyResource")
	public String getAnyResource(@RequestHeader("jwt-token") String token){
		
		//to cross check jwt token
		
		final UserDetails userDetails = jwtService
				.loadUserByUsername(jwtTokenUtil.getUsernameFromToken(token));
		
		if(jwtTokenUtil.validateToken(token, userDetails))
		{
			return "success";
		}else {
			return "failure";
		}
		
		
		
	}


}