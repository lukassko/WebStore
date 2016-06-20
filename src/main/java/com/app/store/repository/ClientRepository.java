package com.app.store.repository;

import java.util.Collection;

import com.app.store.entity.Client;
import com.app.store.entity.Order;
import com.app.store.entity.Product;

public interface ClientRepository {

	public Client findById(int cientId);
	
	public Collection<Order> findAllOrders(int clientId);
	
	public Collection<Product> findAllProduct(int orderId);
	
	public void save(Client client);
	
	public Collection<Client> findAll();
}
