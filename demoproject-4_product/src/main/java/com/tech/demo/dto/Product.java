package com.tech.demo.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String catagiry;
private int cost;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn
private User user;

public int getId() {
	return id;
}
@JsonIgnore
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
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
public String getCatagiry() {
	return catagiry;
}
public void setCatagiry(String catagiry) {
	this.catagiry = catagiry;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}

}
