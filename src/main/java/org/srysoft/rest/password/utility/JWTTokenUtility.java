package org.srysoft.rest.password.utility;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTokenUtility {

	private String secret = "mySecret";
	private Long expiration = 604800L;

	//private Clock clock = DefaultClock.INSTANCE;

	public static void main(String args[]) {

		JWTTokenUtility tokenUtility = new JWTTokenUtility();
		String token = tokenUtility.generateToken("vishal");

		System.out.println("Generated Token: " + token);
		// token: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJWaXNhbCIsImV4cCI6MTU0NzAxNjc5MiwiaWF0IjoxNTQ2NDExOTkyfQ.GTgXi3STdRYjakBne1aV1zNc4Mk__NQ_eA-X8ldJS4qAeOmzbQ_EqhL9EyX4O2IOFC93-191Gb1lz1MNtNrZwA

	}

	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userName);
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		// final Date createdDate = clock.now();
		final Date createdDate = new Date();
		final Date expirationDate = calculateExpirationDate(createdDate);

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(createdDate)
				.setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Date calculateExpirationDate(Date createdDate) {
		return new Date(createdDate.getTime() + expiration * 1000);
	}

}
