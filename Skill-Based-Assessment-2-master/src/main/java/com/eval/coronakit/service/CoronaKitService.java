package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.entity.Cart;
import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.ProductMaster;


public interface CoronaKitService {
public Cart saveToCart(int productId) throws Exception;
	public List<ProductMaster> showAllItems() throws Exception;
	public CoronaKit saveKit(int ProductId);
	public CoronaKit getKitById(int kitId);
	public boolean DeleteFromCart(int productId) throws Exception;
}
