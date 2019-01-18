package org.srysoft.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		// admin - admin
		inMemoryUserList.add(new JwtUserDetails(1L, "admin",
				"$2a$10$K7gmrdFXHCAPnwDSsVXstORcGWAa3yYr4xhEdP7w7XB/pgj68aBAK", "ROLE_ADMIN"));
		// satya - test
		inMemoryUserList.add(new JwtUserDetails(2L, "satya",
				"$2a$10$8a/8AHNMB3/jeJLvSXpCluCJbcZAbmt4FciNPJxnlDPCfuNFCmJSG", "ROLE_USER"));
		
		//ronak - dummy
		inMemoryUserList.add(new JwtUserDetails(2L, "ronak",
				"$2a$10$issATivVmTN9d4dbpaOK3e.H4reWHzO0D7X7sdJJZ3rm3tOE/7q0.", "ROLE_USER"));
		
		//vishal - dummy
		inMemoryUserList.add(new JwtUserDetails(2L, "vishal",
				"$2a$10$issATivVmTN9d4dbpaOK3e.H4reWHzO0D7X7sdJJZ3rm3tOE/7q0.", "ROLE_USER"));
		
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
