package com.eval.coronakit.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eval.coronakit.dao.ProductMasterRepository;
import com.eval.coronakit.entity.ProductMaster;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMasterRepository repo;
	
	@Override
	@Transactional
	public ProductMaster addNewProduct(ProductMaster product) throws Exception {
		
		if(product!=null) {
			if(repo.existsById(product.getId())) {
				throw new Exception("Item code already used!");
			}
			
			repo.save(product);
		}
		return product;
	}
	
	@Override
	@Transactional
	public ProductMaster save(ProductMaster product) throws Exception {
		if(product!=null) {
			if(!repo.existsById(product.getId())) {
				throw new Exception("Item Not Found");
			}
			
			repo.save(product);
		}
		return product;
	}

	@Override
	public List<ProductMaster> getAllProducts() throws Exception{
		return repo.findAll();
	}

	
	@Override
	public ProductMaster getProductById(int productId) {
		return repo.findById(productId).orElse(null);
	}

	@Override
	public boolean deleteProduct(int productId) throws Exception {
		if(!repo.existsById(productId)) {
			throw new Exception("Item Not Found");
		}
	
		repo.deleteById(productId);
		return true;
	}

}
