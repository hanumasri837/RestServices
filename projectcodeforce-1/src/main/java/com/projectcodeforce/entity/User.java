package com.projectcodeforce.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@EntityScan
@Table(value="userdetails")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(value="id")
	private int id;
	
	@Column(value="first_name")
	private String firstName;
	
	@Column(value="last_name")
	private String lastName;
	
	@Column(value="phoneNumber")
	private int phoneNumber;
	
	@Column(value="password")
	private String password;
	
	@Column(value="emailId")
	private String emailId;
	
	public User(String firstName, String lastName, int phoneNumber, String password, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.emailId = emailId;
	}
	public User() {
		// TODO Auto-generated constructor stub
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
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", emailId=" + emailId + "]";
	}
	


}
