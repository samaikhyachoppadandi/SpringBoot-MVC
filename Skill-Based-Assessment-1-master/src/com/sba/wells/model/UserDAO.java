package com.sba.wells.model;

import java.util.List;

import com.sba.wells.entity.Product;

public interface UserDAO {
	List<Product> ListOfAllProducts () throws Exception;
	Product selectProduct(int item_code) throws Exception;
}
