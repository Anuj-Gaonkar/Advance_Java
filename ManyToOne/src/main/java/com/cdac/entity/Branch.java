package com.cdac.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_branch")
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Branch_id")
	private int id;
	
	@Column(name="Branch_name")
	private String name;
	
	@Column(name="Head_of_branch")
	private String HOB;
	
	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
	private List<Student> listOfStudents;
	
	public Branch() {
	}

	public Branch(String name, String hOB) {
		this.name = name;
		HOB = hOB;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHOB() {
		return HOB;
	}

	public void setHOB(String hOB) {
		HOB = hOB;
	}

	public List<Student> getListOfStudents() {
		return listOfStudents;
	}

	public void setListOfStudents(List<Student> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}
	
	

}
