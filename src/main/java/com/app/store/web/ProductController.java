package com.app.store.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.store.service.StoreService;

@Controller
public class ProductController {

	private final StoreService storeService;
	
	@Autowired
	public ProductController(StoreService storeService) {
		this.storeService = storeService;
	}

	@RequestMapping(value = "/products/show", method=RequestMethod.GET)
	public String myCartHandler(@ModelAttribute("clientId") int clientId, Model model) {
		model.addAttribute("products", this.storeService.findAllProduct());
		model.addAttribute("clientId",clientId);
		return "product/productList";
	}
}
