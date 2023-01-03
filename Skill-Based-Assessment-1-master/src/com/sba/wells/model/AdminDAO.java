package com.sba.wells.model;


import java.sql.ResultSet;
import java.util.List;

import com.sba.wells.entity.*;
public interface AdminDAO {

	boolean verifyLogin(Admin test) throws Exception;
	List<Product> ListOfAllProducts () throws Exception;
	int addProduct(Product p) throws Exception;
	int deleteProduct(Product p) throws Exception;
	Product selectProduct(Product p) throws Exception;
	int updateProduct(Product p)  throws Exception;
	 
}
