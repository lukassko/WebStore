package com.app.store.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@Column(name = "date_order")
	private Date date;
	
	@Min(value = 0)
	private BigDecimal totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="shopping_cart", 
     	joinColumns=@JoinColumn(name="order_id",referencedColumnName="ID"), 
     	inverseJoinColumns=@JoinColumn(name="product_id",referencedColumnName="ID"))
	private List<Product> products;
	
	public Order () {
		date = new Date();
		totalPrice = new BigDecimal(0);
	}
	
	/*public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	private List<Product> getProductInternal(){
		if(this.products == null)
			this.products = new LinkedList<Product>();
		return this.products;
	}
	public void addProduct(Product product){
		getProductInternal().add(product);
	}*/
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
