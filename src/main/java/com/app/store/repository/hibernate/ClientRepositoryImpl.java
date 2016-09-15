package com.app.store.repository.hibernate;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.store.entity.Client;
import com.app.store.entity.Order;
import com.app.store.entity.Product;
import com.app.store.repository.ClientRepository;
import com.app.store.utility.PaginationResult;
@Repository
public class ClientRepositoryImpl implements ClientRepository {

	@PersistenceContext
	private EntityManager manager;
	
	public Client findById(int clientId) {
		Query query = this.manager.createQuery("SELECT c FROM Client c WHERE c.id = :id");
		query.setParameter("id", clientId);
		return (Client)query.getSingleResult();
	}
	
	public Client findByEmail(String email) {
		Query query = this.manager.createQuery("SELECT c FROM Client c WHERE c.email = :email");
		query.setParameter("email", email);
		Client client =  (Client)query.getSingleResult();
		return client;
	}

	public Collection<Order> findAllOrders(int clientId) {
		TypedQuery<Order> query = this.manager.createNamedQuery("SELECT o FROM Order o WHERE o.client_id = :id", Order.class);
		query.setParameter("id", clientId);
		return query.getResultList();
	}

	public PaginationResult<Order> filterOrders(int clientId,int page, int maxResult, int maxNavigationPage) {
		String query = "SELECT o FROM Order o WHERE o.client = " + clientId;
		 
		Session hibernateSession = manager.unwrap(Session.class);
		
		
		org.hibernate.Query queryList = hibernateSession.createQuery(query);
		@SuppressWarnings("unchecked")
		PaginationResult<Order> paginationResult = 
				new PaginationResult<Order>(queryList, 
						page, maxResult, maxNavigationPage);
		return paginationResult;
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
