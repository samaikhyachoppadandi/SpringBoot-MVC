package com.sba.wells.entity;

public class Product {
	
private int item_no;
private String item_name;
private int item_cost;
private int item_quantity;

public Product() {
	super();
}
public Product(int item_no) {
	super();
	this.item_no = item_no;
}
public Product(int item_no, String item_name, int item_cost) {
	super();
	this.item_no = item_no;
	this.item_name = item_name;
	this.item_cost = item_cost;
}
public Product(int item_no, String item_name, int item_cost, int item_quantity) {
	super();
	this.item_no = item_no;
	this.item_name = item_name;
	this.item_cost = item_cost;
	this.item_quantity = item_quantity;
}
public Product(String item_name, int item_cost, int item_quantity) {
	super();
	this.item_name = item_name;
	this.item_cost = item_cost;
	this.item_quantity = item_quantity;
}
public int getItem_no() {
	return item_no;
}
public void setItem_no(int item_no) {
	this.item_no = item_no;
}
public String getItem_name() {
	return item_name;
}
public void setItem_name(String item_name) {
	this.item_name = item_name;
}
public int getItem_cost() {
	return item_cost;
}
public void setItem_cost(int item_cost) {
	this.item_cost = item_cost;
}
public int getItem_quantity() {
	return item_quantity;
}
public void setItem_quantity(int item_quantity) {
	this.item_quantity = item_quantity;
}



}
