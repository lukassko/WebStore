package com.app.store.web;


import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.store.entity.Category;
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

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		Object target = binder.getTarget();
		if (target == null) {
			System.out.println("Null target");
	        return;
		}
	     System.out.println("Target " + target);

		if (target.getClass() == Product.class){
			binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		}
	}
	
	@ModelAttribute("categories")
	public Map<Integer,String> getCategories(){
		List<Category> categories = this.storeService.getAllCategories();
		Map<Integer,String> tmp =  new LinkedHashMap<Integer,String>();
		for (Category category : categories){
			tmp.put(category.getId(), category.getName());
		}
		return tmp;
	}
	
	@RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
    public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam("code") String code) throws IOException {
        Product product = null;
        if (code != null) {
        	int id = Integer.parseInt(code);
            product = this.storeService.findProductById(id);
        }
        if (product != null && product.getImage() != null) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(product.getImage());
        }
        response.getOutputStream().close();
    }
	
	@RequestMapping(value = "/products", method=RequestMethod.GET)
	public String showAllProductHandler(Model model) {
		System.out.println("Show all products");
		model.addAttribute("products", this.storeService.findAllProduct());
		return "product/productList";
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
		return "product/newUpdateProduct";
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
		return "product/newUpdateProduct";
	}
	
	@RequestMapping(value = "/products/new", method=RequestMethod.POST)
	public String addNewProduct(@Validated @ModelAttribute("product") Product product, BindingResult result,
			final RedirectAttributes redirectAttributes){
		
		if (product.getImage() != null) 
			System.out.println(product.getImage().toString());
		 else 
			System.out.println("Empty img");
		
		if (result.hasErrors()) {
			return "product/newUpdateProduct";
		} else {
			redirectAttributes.addFlashAttribute("css", "success");
			if (product.isNew())
				redirectAttributes.addFlashAttribute("msg", "Product added successfully!");
			else 
				redirectAttributes.addFlashAttribute("msg", "Product updated successfully!");
		}
		storeService.saveProduct(product);
		return "redirect:/products";
	}
}
