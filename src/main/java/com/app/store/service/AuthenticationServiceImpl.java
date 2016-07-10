package com.app.store.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.store.entity.Client;

public class AuthenticationServiceImpl implements AuthenticationService {

	private StoreService storeService;
	
	@Autowired
	public AuthenticationServiceImpl (StoreService storeService) {
		this.storeService = storeService;
	}
	
	public Client findClientByEmail(String email) {
		Client client = storeService.findClientByEmail(email);
		return null;
	}

}
