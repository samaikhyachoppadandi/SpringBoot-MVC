package com.sba.wells.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sba.wells.entity.Product;

public class UserDAOImp implements UserDAO{

	@Override
	public List<Product> ListOfAllProducts() throws Exception {
		List<Product> productList = new ArrayList<>();
	try {
		Connection con = ConnectionFactory.connect();
		PreparedStatement pst = con.prepareStatement("select * from listofitems");
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
		Product p =  new Product();
		p.setItem_no(rs.getInt(1));
		p.setItem_name(rs.getString(2));
		p.setItem_cost(rs.getInt(3));
		p.setItem_quantity(rs.getInt(4));
		productList.add(p);
		}
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return productList;
	}

	@Override
	public Product selectProduct(int item_code) throws Exception {
		Product np = new Product();
		try {
			Connection con = ConnectionFactory.connect();
			PreparedStatement pst = con.prepareStatement("select item_name,item_cost from listofitems where item_no =?");
			pst.setInt(1, item_code);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
			np.setItem_no(item_code);
			np.setItem_name(rs.getString(1));
			np.setItem_cost(rs.getInt(2));
			}
			}catch(Exception e)
			{
			e.printStackTrace();
			}
		
		return np;
			}
			
}
