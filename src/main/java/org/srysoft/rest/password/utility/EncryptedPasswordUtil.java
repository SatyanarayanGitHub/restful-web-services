package org.srysoft.rest.password.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtil {

	public static String encryptedPassword(String rawPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.encode(rawPassword);
	}

	public static void main(String[] args) {

		String rawPassword = "test";
		String encryptedPassword = encryptedPassword(rawPassword);

		System.out.println("Encrypted password of [" + rawPassword + "] is [" + encryptedPassword + "]");

	}
}
