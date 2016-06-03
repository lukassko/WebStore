package com.app.store.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.store.model.Client;
import com.app.store.model.Order;
import com.app.store.model.Product;
import com.app.store.repository.ClientRepository;


@Service
public class StoreServiceImpl implements StoreService {

	private ClientRepository clientRepository;
	
	@Autowired
	public StoreServiceImpl(ClientRepository clientRepository){
		this.clientRepository = clientRepository;
	}
	
	public Client findClientById(int cientId) {
		return this.clientRepository.findById(cientId);
	}

	public Collection<Order> findAllOrdersForClient(int clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Product> findAllProductForOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	public Collection<Client> findAllClients() {
		// TODO Auto-generated method stub
		return this.clientRepository.findAll();
	}

}
