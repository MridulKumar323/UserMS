package com.infy.infyShop.user.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int prodId;
	@Column(nullable = false)
	String brand;
	@Column(nullable = false)
	String category;
	@Column(nullable = false)
	String description;
	@Column(nullable = false)
	String image;
	@Column(nullable = false)
	double price;
	@Column(nullable = false)
	String productname;
	@Column
	String rating;
	@Column(nullable = false)
	int sellerid;
	@Column(nullable = false)
	int stock;
	@Column(nullable = false)
	String subcategory;
	
	
	public Product() {
		super();
	}
		
		
	public Product(int prodid, String brand, String category, String description, String image, double price,
				String productname, String rating, int sellerid, int stock, String subcategory) {
		super();
		this.prodId = prodid;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.image = image;
		this.price = price;
		this.productname = productname;
		this.rating = rating;
		this.sellerid = sellerid;
		this.stock = stock;
		this.subcategory = subcategory;
	}	
	
	 
	public int getProdId() {
		return prodId;
	}


	public void setProdId(int prodId) {
		this.prodId = prodId;
	}


	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
}