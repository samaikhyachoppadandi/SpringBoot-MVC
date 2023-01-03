package com.sba.wells.model;
 import java.util.*;
import com.sba.wells.model.ConnectionFactory;
import com.sba.wells.entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class AdminDAOImp implements AdminDAO {

	@Override
	public boolean verifyLogin(Admin test) throws Exception{
	
		boolean result= false;
	
			try {
				Connection con = ConnectionFactory.connect();
				PreparedStatement pst = con.prepareStatement("select * from Admin where Name=? and Password=?");
				pst.setString(1,test.getUsername());
				pst.setString(2, test.getPassword());
				ResultSet rs = pst.executeQuery();
				if(rs.next())
				{result = true;}
			}
					
			catch(Exception e)
			{e.printStackTrace();}
		
		return result;
	}

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
	public int addProduct(Product p) throws Exception {
		Connection con = ConnectionFactory.connect();
		PreparedStatement pst = con.prepareStatement("insert into listofitems(item_name,item_cost,item_quantity) values(?,?,?)");
		pst.setString(1,p.getItem_name());
		pst.setInt(2, p.getItem_cost());
		pst.setInt(3, p.getItem_quantity());
		int i = pst.executeUpdate();
		return i;
	}

	@Override
	public int deleteProduct(Product p) throws Exception {
		Connection con = ConnectionFactory.connect();
		int item_no = p.getItem_no();
		System.out.println("Delete :"+item_no);
		PreparedStatement pst = con.prepareStatement("delete from listofitems where item_no =? ");
		pst.setInt(1, item_no);
		int i = pst.executeUpdate();
		return i;
	}

	@Override
	public Product selectProduct(Product p) throws Exception {
		Connection con = ConnectionFactory.connect();
		int item_no = p.getItem_no();
		PreparedStatement pst = con.prepareStatement("select * from listofitems where item_no =?");
		pst.setInt(1, item_no);
		ResultSet rs = pst.executeQuery();
		Product update_product = new Product();
		while(rs.next()) {
			update_product.setItem_no(rs.getInt(1));
			update_product.setItem_name(rs.getString(2));
			update_product.setItem_cost(rs.getInt(3));
			update_product.setItem_quantity(rs.getInt(4));
		}
		return update_product;
	}

	@Override
	public int updateProduct(Product p) throws Exception {
		// TODO Auto-generated method stub
		Connection con = ConnectionFactory.connect();
		int item_no = p.getItem_no();
		String name = p.getItem_name();
		int item_cost =p.getItem_cost();
		int item_q = p.getItem_quantity();
		PreparedStatement pst = con.prepareStatement("update listofitems set item_name=?, item_cost=?, item_quantity=? where item_no =?");
		pst.setString(1, name);
		pst.setInt(2,item_cost);
		pst.setInt(3,item_q);
		pst.setInt(4,item_no);
		int i= pst.executeUpdate();
		return i;
	}

}
