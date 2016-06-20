package com.app.store.service;

import java.util.Collection;

import com.app.store.entity.Client;
import com.app.store.entity.Order;
import com.app.store.entity.Product;

public interface StoreService {
	
	public Client findClientById(int cientId);
	
	public Collection<Order> findAllOrdersForClient(int clientId);
	
	public Collection<Product> findAllProductForOrder(int orderId);
	
	public void saveClient(Client client);
	
	public Collection<Client> findAllClients();
	
	public Collection<Product> findAllProduct();
	
	public Product findProductById(int productId);
}
