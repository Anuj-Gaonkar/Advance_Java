package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Branch;
import com.cdac.entity.Student;

public class StudentBranchDao {
	public void addStudent(Student std) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(std);
		tx.commit();
		
		emf.close();
	}
	
	public void addBranch(Branch branch) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(branch);
		tx.commit();
		
		emf.close();
	}
	
	public Student fetchByStudentId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Student std = em.find(Student.class, id);
		emf.close();
		
		return std;
	}
	
	public Branch fetchByBranchId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Branch branch = em.find(Branch.class, id);
		emf.close();
		
		return branch;
	}
	
	public void update(Student std) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(std); //merge method will generate update query
		
		tx.commit();
		emf.close();
	}
	
	public void update(Branch branch) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(branch); //merge method will generate update query
		
		tx.commit();
		emf.close();
	}

}
