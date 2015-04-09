package com.thisismap.demo.domain;

import java.io.Serializable;

public class PatientAttribute implements Serializable {

	private static final long serialVersionUID = -4343091003906910384L;
	
	private String group;
	private String name;
	private String description;
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
	
}
