package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Address;
import com.cdac.entity.Customer;

public class CustomerAndAddressDao {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("learning-hibernate");
		Runtime.getRuntime().addShutdownHook(new Thread(() -> emf.close()));
	}
	
	public void addCust(Customer customer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(customer);
		tx.commit();
	}
	
	public void updateCust(Customer customer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(customer);
		tx.commit();
	}
	
	public Customer fetchCustomer(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Customer cust = em.find(Customer.class, id);
		tx.commit();
		return cust;
	}
	
	public List<Customer> fetchCustomerByEmail(String domain) {
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select c from Customer c where c.email like :em");
		q.setParameter("em", domain);
		List<Customer> list = q.getResultList();
		
		return list;
	}
	
	public List<Customer> fetchCustomerByCity(String city) {
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select c from Customer c join c.address a where a.city = :ct");
		q.setParameter("ct", city);
		List<Customer> list = q.getResultList();
		
		return list;
	}
	
	public List<Customer> fetchCustomerByName(String name) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Query q = em.createQuery("select a from Customer c join c.address a where c.name = :nm");
		q.setParameter("nm", name);
		List<Customer> list = q.getResultList();
		
		return list;
	}
	
	public void add(Address addr) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(addr); //persist method will generate insert query
		
		tx.commit();
	}

	public Address fetchAddress(int id) {
		EntityManager em = emf.createEntityManager();

		//find method generates select query where pk = ?
		Address addr = em.find(Address.class, id);
		

		return addr;	
	}
}
