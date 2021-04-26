package com.customerinfo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Customerinfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	private String id;
	private String firstname;
	private String lastname;
	private String grade;


	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Customerinfo()	{}
	
	public Customerinfo(String id, String firstname, String lastname, String grade) {
		
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Customerinfo{" +
				"empid=" + empid +
				", id='" + id + '\'' +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", grade='" + grade + '\'' +
				'}';
	}
}
