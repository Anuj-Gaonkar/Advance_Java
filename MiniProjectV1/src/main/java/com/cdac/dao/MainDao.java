package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.User;

public class MainDao {
	public void registerUser(User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(user);
		tx.commit();
		
		emf.close();
	}
	
	public boolean loginVerification(String userid, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select u from User u where u.username = :un");
		q.setParameter("un", userid);
		User user = (User) q.getSingleResult();
		
		boolean verified = false;
		
		if (user != null && userid.equals(user.getUsername()) && password.equals(user.getPassword())) {
			System.out.println("Object found");
			verified = true;
		} 
		
		emf.close();
		return verified;
	}

}
