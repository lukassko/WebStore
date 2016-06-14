package com.app.store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.app.store.service.cart.ShoppingCart;


@Controller
@Scope("request")
public class CartController {

	@Autowired
	ShoppingCart shoopingCart;
}
