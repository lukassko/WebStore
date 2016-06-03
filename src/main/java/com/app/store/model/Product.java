package com.app.store.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product extends BaseEntity {

	@NotEmpty
	private String name;
	
	@NotEmpty
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany(mappedBy = "products")
	private List<Order> orders;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategoryId() {
		return category;
	}

	public void setCategoryId(Category category) {
		this.category = category;
	}
}
