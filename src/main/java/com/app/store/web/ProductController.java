package com.app.store.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.store.entity.Client;
import com.app.store.entity.Product;
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
	
	@RequestMapping(value = "/products/{productId}/edit", method=RequestMethod.GET)
	public String getProductDetail(@PathVariable("productId") int productId, Model model) {

		Product product = this.storeService.findProductById(productId);
		model.addAttribute("product", product);
		return "products/newUpdateProduct";
	}
	
	@RequestMapping(value = "/products/{productId}/edit", method=RequestMethod.POST)
	public String updateProductDetail(@PathVariable("productId") int productId, @Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "product/newUpdateProduct";
		} else {
			product.setId(productId);
			this.storeService.saveProduct(product);
			return "redirect:/products/";
		}
	}
	

	@RequestMapping(value = "/products/new", method=RequestMethod.GET)
	public String initNewProduct(Model model){
		Product product = new Product();
		model.addAttribute("product", product);
		return "products/newUpdateProduct";
	}
	
	@RequestMapping(value = "/products/new", method=RequestMethod.POST)
	public String addNewProduct(@ModelAttribute("product") @Validated Product product, BindingResult result,
			final RedirectAttributes redirectAttributes){
		if (result.hasErrors()) {
			return "products/newProduct";
		} else {
			redirectAttributes.addFlashAttribute("css", "success");
			if (product.isNew())
				redirectAttributes.addFlashAttribute("msg", "Product added successfully!");
			else 
				redirectAttributes.addFlashAttribute("msg", "Product updated successfully!");
		}
		storeService.saveProduct(product);
		return "/products";
	}
}
