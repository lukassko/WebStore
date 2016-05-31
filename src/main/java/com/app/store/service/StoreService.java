package com.app.store.service;

import java.util.Collection;

import com.app.store.model.Client;
import com.app.store.model.Order;
import com.app.store.model.Product;

public interface StoreService {
	
	public Client findClientById(int cientId);
	
	public Collection<Order> findAllOrdersForClient(int clientId);
	
	public Collection<Product> findAllProductForOrder(int orderId);
	
	public void saveClient(Client client);
}
