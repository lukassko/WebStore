package com.app.store.repository;

import java.util.Collection;

import com.app.store.entity.Client;
import com.app.store.entity.Order;
import com.app.store.entity.Product;
import com.app.store.utility.PaginationResult;

public interface ClientRepository {

	public Client findById(int cientId);
	
	public Client findByEmail(String email);
	
	public Collection<Order> findAllOrders(int clientId);
	
	public Collection<Product> findAllProduct(int orderId);
	
	public void save(Client client);
	
	public Collection<Client> findAll();
	
	public PaginationResult<Order> filterOrders(int clientId,int page, int maxResult, int maxNavigationPage);
}
