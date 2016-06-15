package com.app.store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.store.model.Client;
import com.app.store.model.Order;
import com.app.store.repository.ClientRepository;
import com.app.store.repository.OrderRepository;
import com.app.store.service.cart.ShoppingCart;


@Controller
@Scope("request")
@RequestMapping(value = "/clients/{clientId}/orders/new")
public class CartController {

	
	private ShoppingCart shopingCart;
	private OrderRepository orderRepository;
	private ClientRepository clientrRepository;
	
	@Autowired
	public CartController (ShoppingCart shoopingCart, OrderRepository orderRepository, ClientRepository clientrRepository) {
		this.shopingCart = shoopingCart;
		this.orderRepository = orderRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String newOrder(@PathVariable("clientId") int clientId) {
		Client client = this.clientrRepository.findById(clientId);
		this.shopingCart.getOrder().setClient(client);
		return "newOrder";
	}
	
	
}
