package com.app.store.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.store.model.Client;
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
			
	@RequestMapping(value = "/clients/${clientId}/edit", method=RequestMethod.GET)
	public String getClientsDetail(@PathVariable("clientId") int clientId, Model model) {
		Client client = this.storeService.findClientById(clientId);
		model.addAttribute("client", client);
		return "clientDetail";
	}
	
	@RequestMapping(value = "/clients/${clientId}/edit", method=RequestMethod.POST)
	public String updateClientsDetail(@PathVariable("clientId") int clientId, @Valid Client client, BindingResult result) {
		if (result.hasErrors()) {
			return "clientDetail";
		} else {
			client.setId(clientId);
			this.storeService.saveClient(client);
			return "redirect:/clients/{clientId}";
		}
	}
	
	@RequestMapping(value = "/clients/")
	public String findAllClients(Model model){
		model.addAttribute("clients", storeService.findAllClients());
		return "clients/clientList";
	}
	
	@RequestMapping(value = "/clients/new")
	public String addNewClient(){
		return null;
	}
}
