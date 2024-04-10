package com.learning.jwt;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.learning.jwt.model.ApplicationUser;
import com.learning.jwt.model.Role;
import com.learning.jwt.repository.RoleRepository;
import com.learning.jwt.repository.UserRepository;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			Role adminRole = roleRepository.save(new Role(UUID.randomUUID(), "ADMIN"));
			roleRepository.save(new Role(UUID.randomUUID(), "USER"));
			
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			
			ApplicationUser user = new ApplicationUser(UUID.randomUUID(), "Sourav", passwordEncoder.encode("password"), roles);
			userRepository.save(user);
		};
	};
}
