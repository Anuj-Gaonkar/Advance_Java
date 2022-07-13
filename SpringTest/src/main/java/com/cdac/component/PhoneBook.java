package com.cdac.component;

public interface PhoneBook {
	public void add(String name, String number);
	public void remove(String name);
	public void sort(String order);
	public void search(String name);
	public void searchByNumber(String number);
}
