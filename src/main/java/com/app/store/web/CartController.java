package com.app.store.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.store.entity.Client;
import com.app.store.entity.Order;
import com.app.store.entity.Product;
import com.app.store.model.ShoppingCart;
import com.app.store.service.StoreService;
import com.app.store.utility.PaginationResult;

@Controller
@Scope("request")
public class CartController {

	private ShoppingCart shoppingCart;
	private StoreService storeService;
	
	@Autowired
	public CartController (ShoppingCart shoppingCart, StoreService storeService) {
		this.storeService = storeService;
		this.shoppingCart = shoppingCart;
	}
		
	@ModelAttribute("client")
	public Client findClientHandler(@PathVariable("clientId") int clientId){
		Client client = shoppingCart.getClient();
		return client;
	}
	
	@RequestMapping(value = "/showProductInCart", method=RequestMethod.GET)
	public String showProductInCartHandler(Model model) {
		model.addAttribute("products", this.shoppingCart.getProducts().keySet());
		return "cart/shoppingCart";
	}
	
	@RequestMapping(value = "/addProductToCart")
	public String addProductToCartHandler(Model model, @RequestParam(value = "id", defaultValue = "") int productId ) {
		this.shoppingCart.addProduct(this.storeService.findProductById(productId));
		model.addAttribute("products", this.shoppingCart.getProducts());
		return "redirect:/showProductInCart";
	}
	
	@RequestMapping(value = "/showAllProducts",  method=RequestMethod.GET)
	public String showAllProductsHandler(Model model) {
		return "redirect:/products/show";
	}
	
	@RequestMapping(value = "/acceptOrder",  method=RequestMethod.GET)
	public String acceptOrderHandler(@PathVariable("clientId") int clientId) {
		this.storeService.buyProducts(shoppingCart);
		return "redirect:/orders";
	}
	
	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String showOrdersHandler(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userEmail = user.getUsername();
		
		Client client = storeService.findClientByEmail(userEmail);
		this.shoppingCart.setClient(client);
		
		int maxResult = 2;
		int maxNavigationPage = 4;
		
		PaginationResult<Order> paginationResult = storeService.findOrderForClient(client.getId(), 
				page, maxResult, maxNavigationPage);
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
