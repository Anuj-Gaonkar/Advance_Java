package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Answer;
import com.cdac.entity.AnswerBiDirectional;
import com.cdac.entity.Question;
import com.cdac.entity.QuestionBiDirectional;

public class QuestionAnswerDao {
	public void addQuestion(Question q) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(q);
		tx.commit();
		emf.close();
	}
	
	public void addAnswer(Answer ans) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(ans);
		tx.commit();
		emf.close();	
	}
	
	public void update(Question q) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.merge(q);
		tx.commit();
		emf.close();
	}
	
	public void addQuestion(QuestionBiDirectional q) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(q);
		tx.commit();
		emf.close();
	}
	
	public void addAnswer(AnswerBiDirectional ans) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(ans);
		tx.commit();
		emf.close();	
	}
	
	public void update(QuestionBiDirectional q) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.merge(q);
		tx.commit();
		emf.close();
	}
}
