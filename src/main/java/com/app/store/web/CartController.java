package com.app.store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.store.model.ShoppingCart;
import com.app.store.repository.ClientRepository;
import com.app.store.repository.OrderRepository;
import com.app.store.repository.ProductRepository;
import com.app.store.service.StoreService;


@Controller
@Scope("request")
@RequestMapping(value = "/clients/{clientId}/orders/new")
public class CartController {

	private ShoppingCart shoppingCart;
	private final StoreService storeService;
	
	@Autowired
	public CartController (ShoppingCart shoppingCart, StoreService storeService) {
		this.storeService = storeService;
		this.shoppingCart = shoppingCart;
	}
	
	@RequestMapping(value = "/shoppingCart", method=RequestMethod.GET)
	public String myCartHandler(@PathVariable("clientId") int clientId, Model model) {
		model.addAttribute("products", this.shoppingCart.getProducts());
		return "cart/shoppingCart";
	}
	
	@RequestMapping(value = "/buy")
	public String buyProductHandler(@PathVariable("clientId") int clientId, Model model,
			 @RequestParam(value = "id", defaultValue = "") int productId ) {
		System.out.println("Buy for " + clientId + " product no " + productId);
		this.shoppingCart.addProduct(this.storeService.findProductById(productId));
		model.addAttribute("products", this.shoppingCart.getProducts());
		return "redirect:/shoppingCart";
	}
	
	@RequestMapping(value = "/showProducts",  method=RequestMethod.GET)
	public String showProductHandler(@PathVariable("clientId") int clientId, Model model,
			RedirectAttributes redirectAttrs) {
		redirectAttrs.addFlashAttribute("clientId", clientId);
		return "redirect:/products/show";
	}
	
	
}
