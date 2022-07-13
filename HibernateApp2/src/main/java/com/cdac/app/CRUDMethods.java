package com.cdac.app;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Student;

public class CRUDMethods {
	
	public void insertStudent(int rollNumber, String name, int standard) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Student student = new Student();
		student.setRollNumber(rollNumber);
		student.setName(name);
		student.setStandard(standard);
		em.persist(student);
		
		tx.commit();
		
		emf.close();
	}
	
	public Student fetch(int rollNumber) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Student st = em.find(Student.class, rollNumber);
		
		emf.close();
		
		return st;
	}
	
	public List<Student> fetchAll(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select s from Student s");
		List<Student> list = q.getResultList();
		
		emf.close();
		
		return list;	
	}
	
	public List<Student> fetchByStandard(int standard){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select s from Student s where s.standard = :standard");
		q.setParameter("standard", standard);
		
		List<Student> list = q.getResultList();
		
		return list;
		
	}
	
	public List<String> fetchAllNames(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select s.name from Student s");
		List<String> list = q.getResultList();
		return list;
	}
	
	public List<Object[]> fetchAllRollNumbersAndNames() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select s.rollNumber, s.name from Student s");
		List<Object[]> list = q.getResultList();
		
		return list;
	}
	
//	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		
//		Student student = new Student();
//		student.setRollNumber(1);
//		student.setName("Lewis");
//		student.setStandard(5);
//		em.persist(student);
//		
//		tx.commit();
//		
//		emf.close();
//	}
}
