package com.app.store.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "category")
public class Category extends BaseEntity {

	@NotEmpty
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "category", cascade=CascadeType.ALL)
	private List<Product> products;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private List<Product> getProductsInternal(){
		if(this.products == null)
			this.products = new LinkedList<Product>();
		return this.products;
	}
	
	public void addProduct(Product product){
		getProductsInternal().add(product);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

}
