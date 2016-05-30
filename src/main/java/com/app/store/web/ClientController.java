package com.app.store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	//pozbyc sie
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(emailValidator);
	}
	
	@ModelAttribute("client")
	public Client findClient(@PathVariable("clientId") int clientId){
		Client client = storeService.findClientById(clientId);
		return client;
	}
	
	@RequestMapping(value = "/clients/${clientId}", method=RequestMethod.POST)
	public String updateClientsDetail(Model model) {
		return null;
	}
	
	@RequestMapping(value = "/clients/${clientId}", method=RequestMethod.GET)
	public String getClientsDetail(Model model) {
		return null;
	}
	
	
	@RequestMapping(value = "/clients/new")
	public String addNewClient(){
		return null;
	}
}
