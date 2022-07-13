package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Books;

public class BooksDao {
	public void addBook(String name, String author, String genre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Books b = new Books(name, author, genre);
		em.persist(b);
		
		tx.commit();
		emf.close();
	}
	
	public Books fetchBook(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Books book = em.find(Books.class, id);
		
		emf.close();
		
		return book;
	}
}
