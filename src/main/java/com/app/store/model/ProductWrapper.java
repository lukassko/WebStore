package com.app.store.model;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.app.store.entity.BaseEntity;
import com.app.store.entity.Category;
import com.app.store.entity.Product;

public class ProductWrapper extends BaseEntity {
	
	private BigDecimal price;
	private Category category;
	
	private MultipartFile image;

	public ProductWrapper() {
	}
	
	public ProductWrapper(Product product) {
		this.id=product.getId();
		this.price=product.getPrice();
		this.category=product.getCategory();
    }
	
	public ProductWrapper(int id, BigDecimal price, Category category) {
		this.id=id;
		this.price=price;
		this.category=category;
    }
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
}
