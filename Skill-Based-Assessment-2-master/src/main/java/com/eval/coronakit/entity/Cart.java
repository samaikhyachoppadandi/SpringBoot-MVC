package com.eval.coronakit.entity;

public class Cart {
	
	private int Cartid;

	public int getCartid() {
		return Cartid;
	}

	public void setCartid(int cartid) {
		Cartid = cartid;
	}

	private ProductMaster productMaster;
	
	public ProductMaster getProductMaster() {
		return productMaster;
	}

	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}


}
