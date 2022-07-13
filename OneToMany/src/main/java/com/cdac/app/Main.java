package com.cdac.app;

import java.util.ArrayList;
import java.util.List;

import com.cdac.dao.StudentBranchDao;
import com.cdac.entity.Branch;
import com.cdac.entity.Student;

public class Main {
	public static void main(String[] args) {
		
		StudentBranchDao dao = new StudentBranchDao();
		
		/*Student s = new Student("Anuj", "Gaonkar", "anuj@gmail");
		Branch b1 = new Branch("Electronics", "Dr. Mujumdar");
		Branch b2 = new Branch("Electrical", "S. Marathe");
		Branch b3 = new Branch("Electronics and Telecommunication", "Dr. Bobade");
		
		dao.addStudent(s);
		dao.addBranch(b1);
		dao.addBranch(b2);
		dao.addBranch(b3);*/
		
//		Student s1 = dao.fetchByStudentId(1);
		/*Student s1 = new Student("Shilpak", "Patil", "shilpak@gmail");
		Student s2 = new Student("Shamal", "Chopde", "shamal@gmail");
		Student s3 = new Student("Rahul", "Birodkar", "rahul@gmail");
		dao.addStudent(s1);
		dao.addStudent(s2);
		dao.addStudent(s3);*/
		
		/*Student s2 = dao.fetchByStudentId(2);
		Student s3 = dao.fetchByStudentId(3);
		Student s4 = dao.fetchByStudentId(4);*/
		
		/*Branch b1 = dao.fetchByBranchId(1);
		Branch b2 = dao.fetchByBranchId(2);
		Branch b3 = dao.fetchByBranchId(3);*/
		
		/*s1.setBranch(b1);
		s2.setBranch(b1);
		s3.setBranch(b1);
		s4.setBranch(b1);
		
		dao.update(s1);
		dao.update(s2);
		dao.update(s3);
		dao.update(s4);*/
		
		/*Student s1 = new Student("Sumit", "Thakur", "sumit@gmail");
		Student s2 = new Student("Mrunal", "Patil", "mrunal@gmail");
		Student s3 = new Student("Lokita", "Gharat", "lokita@gmail");
		
		s1.setBranch(b2);
		s2.setBranch(b2);
		s3.setBranch(b2);
		
		dao.addStudent(s1);
		dao.addStudent(s2);
		dao.addStudent(s3);*/
		
		/*Student s1 = new Student("Abhishek", "Gaonakr", "abhishek@gmail");
		Student s2 = new Student("Narayan", "Dhuri", "narayan@gmail");
		Student s3 = new Student("Bhalchandra", "Ghodge", "bhalchandra@gmail");
		
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		dao.addStudent(s1);
		dao.addStudent(s2);
		dao.addStudent(s3);
		
		b3.setListOfStudents(list);*/
		System.out.println(Student.class);
		
	}
}
