package com.app.store.repository.hibernate;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.app.store.entity.Client;
import com.app.store.entity.Order;
import com.app.store.entity.Product;
import com.app.store.repository.ClientRepository;

import javax.persistence.Query;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

	@PersistenceContext
	private EntityManager manager;
	
	public Client findById(int clientId) {
		//Client client = manager.find(Client.class, clientId);
		Query query = this.manager.createQuery("SELECT c FROM Client c WHERE c.id = :id");
		query.setParameter("id", clientId);
		return (Client)query.getSingleResult();
		//return client;
	}

	public Collection<Order> findAllOrders(int clientId) {
		TypedQuery<Order> query = this.manager.createNamedQuery("SELECT o FROM Order o WHERE o.client_id = :id", Order.class);
		query.setParameter("id", clientId);
		return query.getResultList();
	}

	public Collection<Product> findAllProduct(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Client client) {
		if(client.isNew()) {
			manager.persist(client);
		} else {
			manager.merge(client);
		}
		
	}

	@SuppressWarnings("unchecked")
	public Collection<Client> findAll() {
		Query query = this.manager.createQuery("SELECT c FROM Client c");
		return query.getResultList();
	}

}
