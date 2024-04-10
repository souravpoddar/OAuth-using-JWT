package com.learning.jwt.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.jwt.model.ApplicationUser;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, UUID>{
	
	Optional<ApplicationUser> findByUserName(String userName);
}
