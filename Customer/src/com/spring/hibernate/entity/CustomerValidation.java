package com.spring.hibernate.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.spring.hibernate.Validation.EmailValidation;

@Component
public class CustomerValidation 
{
	private int id;
	
	@NotNull(message = "Mandatory Field")
	@Size(min = 1 , message = "Minimum character 1 is required")
	@Size(max= 10, message = "Reached maximum character")
	private String firstName;
	
	@NotNull(message = "Mandatory Field")
	@Size(min = 1 , message = "Minimum character 1 is required")
	@Size(max= 10, message = "Reached maximum character")
	private String lastName;
	
	@EmailValidation
	private String email;
	
	public CustomerValidation() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
