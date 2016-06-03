package com.app.store.repository;

import java.util.Collection;

import com.app.store.model.Order;
import com.app.store.model.Product;

public interface OrderRepository {

	public Order findById(int orderId);
		
	public Collection<Product> findAllProduct(int orderId);
	
	public void save(Order order);
	
	public Collection<Order> findAll();
}
