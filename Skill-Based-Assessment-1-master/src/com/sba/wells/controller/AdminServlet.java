package com.sba.wells.controller;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sba.wells.entity.Product;
import com.sba.wells.model.AdminDAO;


import com.sba.wells.model.AdminDAOImp;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet({"/login","/newproduct","/insertproduct","/deleteproduct","/updateproduct","/deleteById","/list","/logout","/editproduct"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		System.out.println("action:"+action);
		String viewName = "";
		try {
			switch (action) {
			case "/newproduct":
				viewName = showNewProductForm(request, response);
				break;
			case "/insertproduct":
				viewName = insertProduct(request, response);
				break;
			case "/deleteproduct":
				viewName = deleteEditProduct(request, response);
				break;
			case "/editproduct":
				viewName = showEditProductForm(request, response);
				break;
			case "/updateproduct":
				viewName = updateProduct(request, response);
				break;
			case "/deleteById":
				viewName = deleteProductById(request,response);
				break;
			case "/list":
				viewName = listAllProducts(request, response);
				break;	
			case "/logout":
				viewName = adminLogout(request, response);
				break;	
			default : viewName = "/notfound.jsp"; break;		
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/CoronaKits.jsp";
	}

	private String listAllProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String view="";
		try {
			AdminDAO verify = (AdminDAO) new AdminDAOImp();
			List<Product> productList= verify.ListOfAllProducts();
			request.setAttribute("products", productList);
			view="/AdminIndex.jsp";
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			view="/ErrorPage.jsp";
		}
		return view;
	}

	private String updateProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view ="";
		int icode = Integer.parseInt(request.getParameter("icode"));
		System.out.println("to be updated item:"+icode);
		String item_name = request.getParameter("item_name");
		int item_cost = Integer.parseInt(request.getParameter("item_cost"));
		int item_quantity = Integer.parseInt(request.getParameter("item_quantity"));
		Product p = new Product(icode,item_name,item_cost,item_quantity);
		AdminDAO verify = (AdminDAO) new AdminDAOImp();
		try {
			int result = verify.updateProduct(p);
			if(result==1)
			{
				view = deleteEditProduct(request,response);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return view;
	}

	private String showEditProductForm(HttpServletRequest request, HttpServletResponse response) {
		int item_code = Integer.parseInt(request.getParameter("icode"));
		System.out.println("update item_code"+ item_code);
		Product p = new Product(item_code);
		AdminDAO verify = (AdminDAO) new AdminDAOImp();
		try {
			Product update_product = verify.selectProduct(p);
			System.out.println(update_product.getItem_name());
			request.setAttribute("Update", update_product);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	

		return "/AdminIndex.jsp";
	}

	private String deleteEditProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			
			AdminDAO verify = (AdminDAO) new AdminDAOImp();
			List<Product> DproductList= verify.ListOfAllProducts();
			request.setAttribute("Dproducts", DproductList);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "/AdminIndex.jsp";
	}

	private String insertProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "";
		String item_name = request.getParameter("item_name");
		int item_cost = Integer.parseInt(request.getParameter("item_cost"));
		int item_quantity = Integer.parseInt(request.getParameter("item_quantity"));
		Product p = new Product(item_name,item_cost,item_quantity);
		AdminDAO verify = (AdminDAO) new AdminDAOImp();
		int result;
		try {
			result = verify.addProduct(p);
			if(result == 1)
			{view = listAllProducts(request,response);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return view;
	}

	private String showNewProductForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.setAttribute("addPage", "addPage");
	
				return "/AdminIndex.jsp";
	}
	private String deleteProductById(HttpServletRequest request, HttpServletResponse response)
		{
		String view ="";
		int item_code =  Integer.parseInt(request.getParameter("icode"));
		System.out.println("item_code"+ item_code);
		Product p = new Product(item_code);
		AdminDAO verify = (AdminDAO) new AdminDAOImp();
		try {
			int i = verify.deleteProduct(p);
			System.out.println("i"+i);
			if(i==1) {
			view = deleteEditProduct(request,response);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
			return view;}
}
