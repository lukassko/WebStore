package com.app.store.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.store.model.Client;
import com.app.store.model.Order;
import com.app.store.model.Product;
import com.app.store.service.StoreService;

@Controller
@RequestMapping(value = "/clients/{clientId}")
public class OrderController {

	private final StoreService storeService;
	
	@Autowired
	public OrderController(StoreService storeService) {
		this.storeService = storeService;
	}
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
	}
	
	@ModelAttribute("client")
	public Client findClient(@PathVariable("clientId") int clientId){
		Client client = storeService.findClientById(clientId);
		return client;
	}

	@RequestMapping(value = "/orders", method=RequestMethod.GET)
	public String getAllOrders(@PathVariable("clientId") int clientId, Model model) {
		Client client = storeService.findClientById(clientId);
		model.addAttribute("client", client);
		//for (Order o : client.getOrders())
			//for (Product p : o.get) {
				
			//}
		return "orders/ordersDetail";
	}
	
	@RequestMapping(value = "/orders/new", method=RequestMethod.GET)
	public String newOrder(@PathVariable("clientId") int clientId) {
		return "newOrder";
	}
	
	@RequestMapping(value = "/orders/{orderId}/products", method=RequestMethod.GET)
	public String getProducts(@PathVariable("orderId") int orderId, Model model) {
		Collection<Product> products = this.storeService.findAllProductForOrder(orderId);
		model.addAttribute("products", products);
		return null;
	}

}
