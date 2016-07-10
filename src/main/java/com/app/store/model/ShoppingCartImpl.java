package com.app.store.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.app.store.entity.Client;
import com.app.store.entity.Order;
import com.app.store.entity.Product;

@Component
@Scope("session")
public class ShoppingCartImpl implements ShoppingCart {

	private Map<Product,Integer> products;
	//private List<Product> products;
	private BigDecimal totalPrice;
	private Order order;
	
	public ShoppingCartImpl () {
		products = new HashMap<Product, Integer>();
		totalPrice = BigDecimal.ZERO;
		order = new Order();
	}
	
	public void setClient(Client client) {
		this.order.setClient(client);
	}
	
	public void addProduct(Product product) {
		if (this.products.containsKey(product)){
			int quantity = this.products.get(product);
			this.products.replace(product, ++quantity);
		} else {
			this.products.put(product, 1);
		}
		calculatePrice();
	}

	public void removeProduct(Product product) {
		if (this.products.containsKey(product)){
			int quantity = this.products.get(product);
			if(quantity > 1) 
				this.products.replace(product, --quantity);
			 else 
				this.products.remove(product);
		} else {
			this.products.put(product, 1);
		}
		calculatePrice();
	}

	public Map<Product, Integer> getProducts() {
		return this.products;
	}
	
	public BigDecimal getPrice(){
		return this.totalPrice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void clearCart() {
		this.products.clear();
	}

	private void calculatePrice(){
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			Product product = entry.getKey();
			Integer quantity = entry.getValue();
			BigDecimal price = product.getPrice().multiply(new BigDecimal(quantity));
			this.totalPrice = this.totalPrice.add(price);
		}
	}

}