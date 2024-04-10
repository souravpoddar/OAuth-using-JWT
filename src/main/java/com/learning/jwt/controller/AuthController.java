package com.learning.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jwt.model.ApplicationUser;
import com.learning.jwt.model.LoginResponseDTO;
import com.learning.jwt.model.RegistrationDTO;
import com.learning.jwt.service.AuthService;

@RestController
@RequestMapping({"/auth"})
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@PostMapping({"/register"})
	public ApplicationUser registerUser(@RequestBody RegistrationDTO body) {
		return	authService.registerUser(body.getUsername(), body.getPassword());
	}
	
	@PostMapping({"/login"})
	public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
		return authService.loginUser(body.getUsername(), body.getPassword());
	}
}
