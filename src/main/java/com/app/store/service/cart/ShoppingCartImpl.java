package com.app.store.service.cart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.app.store.model.Product;

@Component
@Scope("session")
public class ShoppingCartImpl implements ShoppingCart {

	private Map<Product,Integer> products;
	private BigDecimal price;
	
	public ShoppingCartImpl () {
		products = new HashMap<Product, Integer>();
		price = BigDecimal.ZERO;
	}
	
	public void addProduct(Product product) {
		
		calculatePrice();
	}

	public void removeProduct(Product product) {
		calculatePrice();
	}

	public Map<Product, Integer> getProducts() {
		return this.products;
	}
	
	public BigDecimal getPrice(){
		return this.price;
	}

	public void clearCart() {
		this.products.clear();
	}

	private void calculatePrice(){
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			Product product = entry.getKey();
			Integer quantity = entry.getValue();
			BigDecimal price = product.getPrice().multiply(new BigDecimal(quantity));
			this.price = this.price.add(price);
		}
	}
}
