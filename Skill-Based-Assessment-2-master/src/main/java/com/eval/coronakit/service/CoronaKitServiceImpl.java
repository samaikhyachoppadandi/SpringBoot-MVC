package com.eval.coronakit.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eval.coronakit.dao.ProductMasterRepository;
import com.eval.coronakit.entity.Cart;
import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.ProductMaster;


@Service
public class CoronaKitServiceImpl implements CoronaKitService {

	@Autowired
	CoronaKitService KitService;
	
	@Autowired
	ProductMasterRepository Prepo;
	
	@Autowired
	ProductService productService;
	
	Map<Integer,List<Cart>>CartMap=new HashMap<Integer,List<Cart>>();
	List<Cart> MyItems = new ArrayList<Cart>();

	
	@Override
	public CoronaKit getKitById(int kitId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart saveToCart(int productId) throws Exception {
		Cart c = new Cart();
		Random r = new Random();
		c.setCartid(r.nextInt());
		c.setProductMaster(productService.getProductById(productId));
		MyItems.add(c);
		return c;
	}

	@Override
	public List<ProductMaster> showAllItems() throws Exception {
		List<ProductMaster> pd = new ArrayList<ProductMaster>();
			for(Cart emp : MyItems){
			pd.add(emp.getProductMaster()) ;
			}
		return pd;
	}
	
	@Override
	public CoronaKit saveKit(int ProductId) {
		
		return null;
	}

	@Override
	public boolean DeleteFromCart(int productId) throws Exception {
		for(Cart c: MyItems)
		if(c.getProductMaster().getId()==productId) {
			MyItems.remove(c);
		}
	
		else
			throw new Exception("Item Not Found");
		return true;
	}

	
}
