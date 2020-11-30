package com.nf.cjexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//修改的时候，客户端会多传一个oPrice过来，所以忽略未知属性
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductItemEntity {
	private Integer id;
	private String title;
	private int qty;
	private double price;
	private String description;
	
	
	public ProductItemEntity() {
		super();
	}
	public ProductItemEntity(Integer id, String title, int qty, double price, String description) {
		super();
		this.id = id;
		this.title = title;
		this.qty = qty;
		this.price = price;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "ProductItemEntity [id=" + id + ", title=" + title + ", qty=" + qty + ", price=" + price
				+ ", description=" + description + "]";
	}
	
}
