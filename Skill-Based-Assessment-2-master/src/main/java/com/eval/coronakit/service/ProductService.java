package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.entity.ProductMaster;

public interface ProductService {

	public ProductMaster addNewProduct(ProductMaster product) throws Exception;
	public List<ProductMaster> getAllProducts() throws Exception;
	public boolean deleteProduct(int productId) throws Exception;
	public ProductMaster getProductById(int productId) throws Exception;
	public ProductMaster save (ProductMaster product) throws Exception;
}
