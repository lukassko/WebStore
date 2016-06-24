package com.app.store.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.store.entity.Client;
import com.app.store.entity.Order;
import com.app.store.entity.Product;
import com.app.store.model.ShoppingCart;
import com.app.store.repository.ClientRepository;
import com.app.store.repository.OrderRepository;
import com.app.store.repository.ProductRepository;


@Service
public class StoreServiceImpl implements StoreService {

	private ClientRepository clientRepository;
	private OrderRepository orderRepository;
	private ProductRepository productRepository;
	
	@Autowired
	public StoreServiceImpl(ClientRepository clientRepository, OrderRepository orderReposotory, 
			ProductRepository productRepository){
		this.clientRepository = clientRepository;
		this.orderRepository = orderReposotory;
		this.productRepository = productRepository;
	}
	
	public Client findClientById(int cientId) {
		return this.clientRepository.findById(cientId);
	}

	public Collection<Order> findAllOrdersForClient(int clientId) {
		return null;
	}

	public Collection<Product> findAllProductForOrder(int orderId) {
		return null;
	}

	@Transactional
	public void saveClient(Client client) {
		this.clientRepository.save(client);
		
	}

	public Collection<Client> findAllClients() {
		return this.clientRepository.findAll();
	}

	public Collection<Product> findAllProduct() {
		return this.productRepository.findAll();
	}

	public Product findProductById(int productId) {
		return this.productRepository.findById(productId);
	}

	public void buyProducts(Client client, ShoppingCart shoppingCart) {
		Map<Product,Integer> products = shoppingCart.getProducts();
		List<Product> productList = new LinkedList<Product>();
		productList.addAll(products.keySet());
		Order order = new Order();
		order.setClient(client);
		order.setTotalPrice(shoppingCart.getPrice());
		order.setProducts(productList);
		this.orderRepository.save(order);
	}

}
