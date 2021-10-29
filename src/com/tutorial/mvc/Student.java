package com.tutorial.mvc;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
	
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;
	
	private String country;
	private List<String> operatingSystems;
	
	
	@Min(value = 0, message = "must be greater or equals 0")
	@Max(value = 10, message = "must be less or equals 10")
	private int freePasses;
	
	public Student() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(List<String> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	

}
