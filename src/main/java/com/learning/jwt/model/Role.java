package com.learning.jwt.model;

import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority{
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="role_id")
	private UUID roleId;
	
	private String authority;

	@Override
	public String getAuthority() {
		
		return this.authority;
	}

}
