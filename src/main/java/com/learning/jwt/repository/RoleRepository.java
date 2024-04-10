package com.learning.jwt.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.jwt.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID>{

	Optional<Role> findByAuthority(String authority);
}
