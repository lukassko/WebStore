package com.app.store.service.cart;

import java.math.BigDecimal;
import java.util.Map;

import com.app.store.model.Product;

public interface ShoppingCart {

	public void addProduct(Product product);
	
	public void removeProduct(Product product);
	
	public Map<Product,Integer> getProducts();
	
	public void clearCart();
	
	public BigDecimal getPrice();
	
}
