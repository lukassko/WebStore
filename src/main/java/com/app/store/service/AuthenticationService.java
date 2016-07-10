package com.app.store.service;

import com.app.store.entity.Client;

public interface AuthenticationService {
	
	Client findClientByEmail(String email);
}
