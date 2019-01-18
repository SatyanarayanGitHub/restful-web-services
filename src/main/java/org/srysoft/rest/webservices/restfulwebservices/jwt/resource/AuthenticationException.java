package org.srysoft.rest.webservices.restfulwebservices.jwt.resource;
public class AuthenticationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}

