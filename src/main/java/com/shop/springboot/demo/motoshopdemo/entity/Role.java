package com.shop.springboot.demo.motoshopdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="role")
	private String role;
	
	/* CONSTRUCTORS */
	public Role() {
		
	}

	public Role(String role) {
		this.role = role;
	}

	/* GETTERS AND SETTERS */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/* toString */
	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}
	
}
