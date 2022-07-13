package com.cdac.component;

import org.springframework.stereotype.Component;

@Component
public class PhoneBookImpl implements PhoneBook {

	public void add(String name, String number) {
		// TODO Auto-generated method stub
		System.out.println("Name: "+name+" Number: "+number);
	}

	public void remove(String name) {
		// TODO Auto-generated method stub
		System.out.println("Removed: "+name);
		
	}

	public void sort(String order) {
		// TODO Auto-generated method stub
		System.out.println("Sordting");
	}

	public void search(String name) {
		// TODO Auto-generated method stub
		System.out.println("Search: "+name);
	}

	public void searchByNumber(String number) {
		// TODO Auto-generated method stub
		System.out.println("Search: "+number);
	}
	
}
