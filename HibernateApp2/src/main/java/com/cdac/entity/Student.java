package com.cdac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_students")
public class Student {
	
	@Id
	@Column(name= "roll_number")
	private int rollNumber;
	
	@Column(name="Full_Name")
	private String name;
	
	@Column(name="Standard")
	private int standard;
	
	public void add(int rollNumber, String name, int standard) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.standard = standard;
	}
	
	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", standard=" + standard + "]";
	}
	
	
}
