package com.app.store.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.store.entity.Client;
import com.app.store.entity.Order;
import com.app.store.entity.Product;
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

}
