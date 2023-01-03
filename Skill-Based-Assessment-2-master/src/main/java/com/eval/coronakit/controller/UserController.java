package com.eval.coronakit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CoronaKitService coronaKitService;
	
	@Autowired
	KitDetailService kitDetailService;
	
	@RequestMapping("/home")
	public String home() {
		return "user-home";
	}
	@RequestMapping("/show-list") //list of all items
	public ModelAndView showList(Model model) throws Exception {
		return new ModelAndView("show-all-item-user","products",productService.getAllProducts());
	}
	
	@RequestMapping("/add-to-cart") //add to cart button 
	public ModelAndView AddToCart(@RequestParam("id") int productId) throws Exception {
		coronaKitService.saveToCart(productId);
		ModelAndView mv = new ModelAndView("user-home","msg","Product"+ productId+"is added to cart");
		return mv;
	}
	
	@RequestMapping("/show-kit") // items of the user added in the cart
	public ModelAndView showKit() throws Exception {
		 
		return new ModelAndView("show-cart","products",coronaKitService.showAllItems());
	}

	
	@RequestMapping("/checkout")
	public String checkout(Model model) {
		return null;
	}
	
	@RequestMapping("/finalize")
	public String finalizeOrder(String address,Model model) {
		return null;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteItem(@RequestParam("id") int itemId) throws Exception {
		coronaKitService.DeleteFromCart(itemId);
		return new ModelAndView("user-home","msg","Product "+itemId+"deleted from the cart");
	}
}
