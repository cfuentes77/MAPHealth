package com.thisismap.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Patient implements Serializable {

	private static final long serialVersionUID = 6424095408207587080L;
	
	private String firstName;
	private String lastName;
	private String email;
	private List<PatientAttribute> attributes;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<PatientAttribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<PatientAttribute> attributes) {
		this.attributes = attributes;
	}
	
	public void addAttribute(PatientAttribute anAttribute) {
		if (this.attributes == null) {
			this.attributes = new ArrayList<PatientAttribute>();
		}
		this.attributes.add(anAttribute);
	}
	
	
}
