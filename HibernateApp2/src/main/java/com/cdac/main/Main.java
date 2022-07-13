package com.cdac.main;

import java.util.List;

import com.cdac.app.CRUDMethods;
import com.cdac.entity.Student;

public class Main {
	public static void main(String[] args) {
		CRUDMethods cm = new CRUDMethods();
		Student st = null;
//		
//		cm.insertStudent(3, "Sebastian", 5);
//		cm.insertStudent(4, "George", 5);
//		cm.insertStudent(5, "Lando", 5);
//		cm.insertStudent(6, "Michael", 10);
		
//		st = cm.fetch(1);
//		
//		System.out.println(st);
//		
//		List<Student> listOfAllStudents = cm.fetchAll();
//		System.out.println(listOfAllStudents);
//		
//		List<Student> listWithStandard = cm.fetchByStandard(10);
//		System.out.println(listWithStandard);
		
		List<Object[]> listOfRollAndNames = cm.fetchAllRollNumbersAndNames();
		System.out.println(listOfRollAndNames);
		
	}
}
