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
import org.springframework.web.bind.annotation.RequestParam;

import com.app.store.entity.Client;
import com.app.store.entity.Order;
import com.app.store.entity.Product;
import com.app.store.service.StoreService;
import com.app.store.utility.PaginationResult;

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
	public Client findClientHandler(@PathVariable("clientId") int clientId){
		Client client = storeService.findClientById(clientId);
		return client;
	}

	@RequestMapping(value = "/orders", method=RequestMethod.GET)
	public String getFilteredOrdersHandler(@PathVariable("clientId") int clientId, 
            @RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		Client client = storeService.findClientById(clientId);
		
		final int maxResult = 2;
		final int maxNavigationPage = 4;
		
		PaginationResult<Order> paginationResult = storeService.findOrderForClient(clientId, 
				page, maxResult, maxNavigationPage);
		model.addAttribute("client", client);
		model.addAttribute("orders", paginationResult);
		return "orders/ordersDetail";
	}
	
	@RequestMapping(value = "/orders/{orderId}/products", method=RequestMethod.GET)
	public String getProductsHandler(@PathVariable("orderId") int orderId, Model model) {
		Collection<Product> products = this.storeService.findAllProductForOrder(orderId);
		model.addAttribute("products", products);
		return null;
	}

}
