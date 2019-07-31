package com.bebo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "users")
public class User {

	@Id
	@Column(name = "idUsers")
	int idUsers;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "mobile_num")
	int mobileNum;
	
	@Column(name = "password")
	String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	Set<Address> address = new HashSet<Address>();
	
	
	
	public int getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(int mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int idUsers, String name, String email, int mobileNum, String password, Set<Address> address) {
		super();
		this.idUsers = idUsers;
		this.name = name;
		this.email = email;
		this.mobileNum = mobileNum;
		this.password = password;
		this.address = address;
	}

	
	
	



	
	
}
