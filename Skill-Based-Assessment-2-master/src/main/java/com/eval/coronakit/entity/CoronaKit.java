package com.eval.coronakit.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoronaKit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int CartId;
	private String deliveryAddress;
	private String orderDate;
	private int totalAmount;
	public CoronaKit() {
		// TODO Auto-generated constructor stub
	}

	
	public CoronaKit(int id, int CartId, String deliveryAddress, String orderDate, int totalAmount) {
		super();
		this.id = id;
		this.CartId= CartId;
		this.deliveryAddress = deliveryAddress;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getCartId() {
		return CartId;
	}

	public void setCartId(int cartId) {
		CartId = cartId;
	}
}
