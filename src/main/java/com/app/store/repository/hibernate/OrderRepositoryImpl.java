package com.app.store.repository.hibernate;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.app.store.model.Order;
import com.app.store.model.Product;
import com.app.store.repository.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository {

	@PersistenceContext
	private EntityManager manager;
	
	public Order findById(int orderId) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public Collection<Product> findAllProduct(int orderId) {
		Query query = this.manager.createQuery("SELECT DISTINCT p FROM Product p JOIN p.orders o where o.id=:id");
		query.setParameter("id", orderId);
		return query.getResultList();
	}

	public void save(Order order) {
	}

	public Collection<Order> findAll() {
		return null;
	}

}