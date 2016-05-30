package com.app.store.repository;

import java.util.Collection;

import com.app.store.model.Client;
import com.app.store.model.Order;
import com.app.store.model.Product;

public interface ClientRepository {

	public Client findById(int cientId);
	
	public Collection<Order> findAllOrders(int clientId);
	
	public Collection<Product> findAllProduct(int orderId);
	
	public void addClient(Client client);
}
