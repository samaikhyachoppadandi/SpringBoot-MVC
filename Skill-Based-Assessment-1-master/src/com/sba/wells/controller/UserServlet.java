package com.sba.wells.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sba.wells.entity.*;
import com.sba.wells.model.*;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/showproducts","/addnewitem","/newuser","/deleteitem","/showkit"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 String action = request.getServletPath();
		
		String viewName = "";
		try {
			switch (action) {
			case "/newuser":
				viewName = showNewUserForm(request, response);
				break;
			case "/showproducts":
				viewName = showAllProducts(request, response);
				break;	
			case "/addnewitem":
				viewName = addNewItemToKit(request, response);
				break;
			case "/deleteitem":
				viewName = deleteItemFromKit(request, response);
				break;
			case "/showkit":
				viewName = showKitDetails(request, response);
				break;
			case "placeorder":
				viewName = showPlaceOrderForm(request, response);
				break;
			case "saveorder":
				viewName = saveOrderForDelivery(request, response);
				break;	
			case "ordersummary":
				viewName = showOrderSummary(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;	
			}
		} catch (Exception ex) {
			
			throw new ServletException(ex.getMessage());
		}
			RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
	
	}
	private String showAllProducts(HttpServletRequest request, HttpServletResponse response) {
		
			// TODO Auto-generated method stub
		String cuser = request.getParameter("cuser");
		request.setAttribute("cuser", cuser);
			String view="";
			try {
				
				UserDAO verify = (UserDAO) new UserDAOImp();
				List<Product> productList= verify.ListOfAllProducts();
				request.setAttribute("products", productList);
				view="/UserIndex.jsp";
			} catch (Exception e) {
				request.setAttribute("errMsg", e.getMessage());
			}
			return view;
		}
	
	private String addNewItemToKit(HttpServletRequest request, HttpServletResponse response) {
		String username = (String) request.getAttribute("cuser");
		int icode = Integer.parseInt(request.getParameter("icode"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String product_name = "";
		Product add_product = new Product();
		UserDAO p = new UserDAOImp();
		try {
			Product add_prod  = p.selectProduct(icode);
			add_product.setItem_no(add_prod.getItem_no());
			add_product.setItem_name(add_prod.getItem_name());
			add_product.setItem_cost(add_prod.getItem_cost());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cart customer = new Cart();
		add_product.setItem_quantity(quantity);
	customer.setUsername(username);
	customer.setMyProducts(add_product);
	product_name = add_product.getItem_name();
	List<Cart> Myitems = new ArrayList<Cart>();
		Myitems.add(customer);
	request.setAttribute("MyCart",Myitems);
	request.setAttribute("item_name", product_name);
	String view = showAllProducts(request,response);
	request.setAttribute("MSG", "Your Product is added to cart");
		return view;
	}

	private String showOrderSummary(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String saveOrderForDelivery(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showPlaceOrderForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showKitDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.setAttribute("showKit","showKit");
		String cuser = (String)request.getAttribute("cuser");
		request.setAttribute("cuser", cuser);
		return "/UserIndex.jsp";
		
	}

	private String deleteItemFromKit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showNewUserForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String user = request.getParameter("customer_name");
		request.setAttribute("cuser", user);
		return "/UserIndex.jsp";
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
