package com.app.store.model;

import java.math.BigDecimal;
import java.util.Map;

import com.app.store.entity.Order;
import com.app.store.entity.Product;

public interface ShoppingCart {

	public void addProduct(Product product);
	
	public void removeProduct(Product product);
	
	public Map<Product,Integer> getProducts();
	
	public void clearCart();
	
	public BigDecimal getPrice();
	
	public Order getOrder();
	
}
