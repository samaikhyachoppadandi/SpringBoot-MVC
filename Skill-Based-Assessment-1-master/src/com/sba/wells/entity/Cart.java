package com.sba.wells.entity;

public class Cart {

	private String username;
	private Product MyProducts;
	public Cart( String username, Product MyProducts) {
		super();
		this.username = username;
		this.MyProducts = MyProducts;
		// TODO Auto-generated constructor stub
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Product getMyProducts() {
		return MyProducts;
	}
	public void setMyProducts(Product myProducts) {
		MyProducts = myProducts;
	}

	
}
