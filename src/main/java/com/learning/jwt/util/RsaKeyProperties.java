package com.learning.jwt.util;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class RsaKeyProperties {

	private RSAPrivateKey privateKey;
	private RSAPublicKey publicKey;
	
	public RsaKeyProperties() {
		KeyPair keyPair = KeyGeneratorUtil.generateRSAKey();
		privateKey = (RSAPrivateKey) keyPair.getPrivate();
		publicKey = (RSAPublicKey) keyPair.getPublic();
	}
}
