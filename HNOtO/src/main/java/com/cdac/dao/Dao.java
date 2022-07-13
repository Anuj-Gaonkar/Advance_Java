package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Customer;
import com.cdac.entity.Transaction;

public class Dao {
	public void addTxn(Transaction txn) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.persist(txn);	
		tx.commit();
	
		emf.close();
	}
	
	
	public void addCust(Customer cust) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.persist(cust);	
		tx.commit();
	
		emf.close();
	}
	
	public void update(Customer cust) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.merge(cust);	
		tx.commit();
	
		emf.close();
	}
	
	public Customer fetchCustomersById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Customer cust = em.find(Customer.class, id);
		
		emf.close();
		
		return cust;
	}
	
	public Transaction fetchTransactionById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Transaction txn = em.find(Transaction.class, id);
		
		emf.close();
		
		return txn;
	}
	
	public List<Customer> fetchByName(String name){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		// select * from tbl_tcust where name = ?;
		Query q = em.createQuery("select c from Customer c where c.name = :nm");
		q.setParameter("nm", name);
		List<Customer> list = q.getResultList();
		emf.close();
		
		return list;
	}
	
	public List<Customer> fetchByTransactionId(int id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		//select * from tbl_tcust c join tbl_txn t on c.txn_id = t.txn_id where t.txn_id = ?;
		Query q = em.createQuery("select c from Customer c join c.transaction t where c.id = :id");
		q.setParameter("id", id);
		
		List<Customer> list = q.getResultList();
		emf.close();
		
		return list;
	}
	
	public List<Object[]> fetchSomeByTransactionId(int id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		//select * from tbl_tcust c join tbl_txn t on c.txn_id = t.txn_id where t.txn_id = ?;
		Query q = em.createQuery("select c.name, c.email, c.address from Customer c join c.transaction t where c.id = :id");
		q.setParameter("id", id);
		
		List<Object[]> list = q.getResultList();
		emf.close();
		
		return list;
	}
	
}
