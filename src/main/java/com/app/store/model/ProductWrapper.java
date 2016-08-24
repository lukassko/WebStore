package com.app.store.model;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.app.store.entity.Category;
import com.app.store.entity.Product;

public class ProductWrapper {

	private String name;

	private BigDecimal price;
	
	private Category category;
	
	private MultipartFile image;
	
	public ProductWrapper() {
    }
	
	public ProductWrapper(Product product) {
		this.name = product.getName();
		this.price = product.getPrice();
		this.category = product.getCategory();
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public MultipartFile getFileData() {
		return image;
	}

	public void setFileData(MultipartFile fileData) {
		this.image = fileData;
	}
	
}
