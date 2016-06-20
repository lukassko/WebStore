package com.app.store.repository.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.app.store.entity.Client;
import com.app.store.entity.Product;
import com.app.store.repository.ProductRepository;
import com.app.store.utility.PaginationResult;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@PersistenceContext
	private EntityManager manager;
	
	public PaginationResult<Product> queryProduct(int page, int maxResult) {
		String sql = "Select new " + Product.class.getName() 
				+ " from " + Product.class.getName() + " p";
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		Query query = this.manager.createQuery("SELECT p FROM Product p");
		return query.getResultList();
	}

	
	public Product findById(int productId) {
		Query query = this.manager.createQuery("SELECT p FROM Product p WHERE p.id = :id");
		query.setParameter("id", productId);
		return (Product)query.getSingleResult();
	}

}
