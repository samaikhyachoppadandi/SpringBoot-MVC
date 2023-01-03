package com.eval.coronakit.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.ProductService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;
	
	
	@GetMapping("/home")
	public String home() {
		return "admin-home";
	}
	
	@GetMapping("/product-entry")
	public ModelAndView showproductEntryForm(Model model) {
		ModelAndView mv = new ModelAndView("add-new-item","product", new ProductMaster());
		mv.addObject("isNew",true);
		return mv;
	}
	
	@PostMapping("/addItem")
	public ModelAndView doAddProduct(@ModelAttribute("product") @Valid ProductMaster product,BindingResult result) throws Exception
	{
		ModelAndView mv=null;
		
		if(result.hasErrors()) {
			mv =new ModelAndView("add-new-item","product",product);
			mv.addObject("isNew",true);
		}else {
			productService.addNewProduct(product);
			mv = new ModelAndView("admin-home","msg","Item is saved!");
		}
		
		return mv;
	}
	
	@PostMapping("/product-save")
	public ModelAndView productSave(@ModelAttribute("product") @Valid ProductMaster product,BindingResult result ) throws Exception 
		{
		
		ModelAndView mv=null;
		
		if(result.hasErrors()) {
			mv =new ModelAndView("add-new-item","product",product);
			mv.addObject("isNew",false);
		}else {
			productService.save(product);
			mv = new ModelAndView("admin-home","msg","Item is saved!");
		}
		
		return mv;
	}
	

	@GetMapping("/product-list")
	public ModelAndView productList() throws Exception {
		return new ModelAndView("show-all-item-admin","products",productService.getAllProducts());
	}
	
	@GetMapping("/product-edit")
	public ModelAndView productEdit(@RequestParam("id") int productId) throws Exception {
		ProductMaster item = productService.getProductById(productId);
		ModelAndView mv = new ModelAndView("add-new-item","product",item);
		mv.addObject("isNew",false);				
		return mv;
	}
	
	@GetMapping("/product-delete")
	public ModelAndView productDelete(@RequestParam("id") int productId) throws Exception {
		productService.deleteProduct(productId);
		return new ModelAndView("admin-home","msg","Item is deleted!");
	}
	
	@RequestMapping("/aheader")
	public String showHeader() {
		return "admin-header";
	}
	
}
