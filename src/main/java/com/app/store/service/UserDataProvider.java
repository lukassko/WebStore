package com.app.store.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.app.store.entity.Client;

public class UserDataProvider implements UserDetailsService {

	@Autowired
	private StoreService storeService;
	
	public UserDetails loadUserByUsername(String email) {
		
		Client client = this.storeService.findClientByEmail(email);
		
		if (client == null) {
			throw new UsernameNotFoundException("User for email " + email + " not found.");
		}
		String role = client.getRole();
		
		Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role);
		authorities.add(authority);
		
		return new User(client.getName(), client.getPassword(), true, true, true, true, authorities);
	}

}
