package com.app.store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.store.model.Order;
import com.app.store.service.cart.ShoppingCart;


@Controller
@Scope("request")
@RequestMapping(value = "/clients/{clientId}/orders/new")
public class CartController {

	@Autowired
	ShoppingCart shoopingCart;
	
	@RequestMapping(method=RequestMethod.GET)
	public String newOrder(@PathVariable("clientId") int clientId) {
		return "newOrder";
	}
}
