package com.app.store.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "client")
public class Client extends BaseEntity {

	@NotEmpty
	private String name;
	
	@NotEmpty
	private String lastName;
	
	private String email;
	
	private String password;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	protected List<Order> getOrdersInternal(){
		if(this.orders == null)
			this.orders = new LinkedList<Order>();
		return this.orders;
	}
	
	public void addOrder(Order Order){
		getOrdersInternal().add(Order);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return "Name " + this.name + "; Last name " + this.lastName;
	}
}
