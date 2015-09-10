package com.bairagi.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private int id;
	
	@XmlElement
	private String email;
	
	@XmlElement
	private String password;
	
	@XmlElement
	private String firstname;
	
	@XmlElement
	private String lastname;
	
	public User(){
		
	}

	public User(String email, String password,String firstname,String lastname) {
		this.email=email;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

	

}
