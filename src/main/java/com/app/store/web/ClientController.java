package com.app.store.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.store.entity.Client;
import com.app.store.model.ShoppingCart;
import com.app.store.service.StoreService;
import com.app.store.utility.EmailValidator;

@Controller
public class ClientController {

	private final StoreService storeService;
	private final EmailValidator emailValidator;
	
	@Autowired
	public ClientController(StoreService storeService, EmailValidator emailValidator) {
		this.storeService = storeService;
		this.emailValidator = emailValidator;
	}

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.setDisallowedFields("id");
		binder.addValidators(emailValidator);
	}
		
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String loginHandler() {
		return "others/login";
	}
	
	@RequestMapping(value = "/fail", method=RequestMethod.GET)
	public String failHandler() {
		return "others/fail";
	}
	
	
	@RequestMapping(value = "/clients/{clientId}/edit", method=RequestMethod.GET)
	public String getClientsDetail(@PathVariable("clientId") int clientId, Model model) {
		Client client = this.storeService.findClientById(clientId);
		model.addAttribute("client", client);
		return "clients/newUpdateClient";
	}
	
	@RequestMapping(value = "/clients/{clientId}/edit", method=RequestMethod.POST)
	public String updateClientsDetail(@PathVariable("clientId") int clientId, @Valid Client client, BindingResult result) {
		if (result.hasErrors()) {
		for (ObjectError o : result.getAllErrors()) {
			System.out.println(o.toString());
		}
			return "clients/newUpdateClient";
		} else {
			client.setId(clientId);
			this.storeService.saveClient(client);
			return "redirect:/clients/";
		}
	}
	
	@RequestMapping(value = "/clients")
	public String findAllClients(Model model){
		model.addAttribute("clients", storeService.findAllClients());
		return "clients/clientList";
	}
	
	@RequestMapping(value = "/clients/new", method=RequestMethod.GET)
	public String initNewClient(Model model){
		Client client = new Client();
		model.addAttribute("client", client);
		return "clients/newUpdateClient";
	}
	
	@RequestMapping(value = "/clients/new", method=RequestMethod.POST)
	public String addNewClient(@ModelAttribute("client") @Validated Client client, BindingResult result,
			final RedirectAttributes redirectAttributes){
		if (result.hasErrors()) {
			return "clients/newUpdateClient";
		} else {
			redirectAttributes.addFlashAttribute("css", "success");
			if (client.isNew())
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			else 
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
		}
		storeService.saveClient(client);
		return "redirect:/clients/" + client.getId()+"/orders";
	}
}
