package com.app.store.service;

import java.util.Collection;
import java.util.List;

import com.app.store.entity.Category;
import com.app.store.entity.Client;
import com.app.store.entity.Order;
import com.app.store.entity.Product;
import com.app.store.model.ShoppingCart;
import com.app.store.utility.PaginationResult;

public interface StoreService {
	
	public Client findClientById(int cientId);
	
	public Client findClientByEmail(String email);
	
	public Collection<Order> findAllOrdersForClient(int clientId);
	
	public Collection<Product> findAllProductForOrder(int orderId);
	
	public void saveClient(Client client);
	
	public Collection<Client> findAllClients();
	
	public Collection<Product> findAllProduct();
	
	public Product findProductById(int productId);
	
	public void buyProducts(Client client, ShoppingCart shoppingCart);
	
	public void saveProduct(Product product);
	
	public Category findCategoryById(int categoryId);
	
	public List<Category> getAllCategories () ;
	
	public PaginationResult<Order> findOrderForClient(int clientId,int page, int maxResult, int maxNavigationPage);
}
