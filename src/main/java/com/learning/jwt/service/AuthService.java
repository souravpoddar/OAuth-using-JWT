package com.learning.jwt.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.jwt.model.ApplicationUser;
import com.learning.jwt.model.LoginResponseDTO;
import com.learning.jwt.model.Role;
import com.learning.jwt.repository.RoleRepository;
import com.learning.jwt.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	public ApplicationUser registerUser(String username, String password) {
		String encodedPassword = passwordEncoder.encode(password);
		Role role = roleRepository.findByAuthority("USER").get();
		Set<Role> authority = new HashSet<>();
		authority.add(role);
		 
		return userRepository.save(new ApplicationUser(UUID.randomUUID(), username, encodedPassword, authority));
	}
	
	public LoginResponseDTO loginUser(String username, String password) {
		try {
			Authentication auth = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			String token = tokenService.generateJwt(auth);
			return new LoginResponseDTO(userRepository.findByUserName(username).get(), token);
		}catch (Exception e) {
			e.printStackTrace();
			return new LoginResponseDTO(null, "");
		}
	}
}
