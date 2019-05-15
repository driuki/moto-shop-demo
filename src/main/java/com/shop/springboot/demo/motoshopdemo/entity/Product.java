package com.shop.springboot.demo.motoshopdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="model")
	private String model;
	
	@Column(name="year")
	private int year;
	
	@Column(name="engine")
	private int engine;
	
	@Column(name="price")
	private int price;
	
	@Column(name="product_Img")
	private String productImg;
	
	/* CONSTRUCTORS */
	public Product() {
		
	}

	public Product(String name, String model, int year, int engine, int price) {
		this.name = name;
		this.model = model;
		this.year = year;
		this.engine = engine;
		this.price = price;
	}
	
	/* GETTERS AND SETTERS */
	public int getId() {
		return id;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", model=" + model + ", year=" + year + ", engine=" + engine
				+ ", price=" + price + ", productImg=" + productImg + "]";
	}
	
}
