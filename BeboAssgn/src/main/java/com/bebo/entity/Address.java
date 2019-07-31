package com.bebo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "address")
public class Address {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAddress")
	int idAddress;
	
	@ManyToOne
	@JoinColumn(name ="fk_user")
	User user;
	
	@Column(name = "street")
	String street;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "state")
	String state;
	
	@Column(name = "country")
	String country;

	public int getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public Address(int idAddress, User user, String street, String city, String state, String country) {
		super();
		this.idAddress = idAddress;
		this.user = user;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
