package com.app.store.repository;

import java.util.List;

import com.app.store.entity.Category;
import com.app.store.entity.Product;
import com.app.store.utility.PaginationResult;

public interface ProductRepository {

	public PaginationResult<Product> queryProduct(int page, int maxResult);
	
	public Product findById(int productId);
	
	public List<Product> findAll();
	
	public void save(Product product);
	
	Category findCategoryById(int categoryId);
	
	List<Category> getCategories();
}
