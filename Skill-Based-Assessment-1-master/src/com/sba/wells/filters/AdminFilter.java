package com.sba.wells.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


import com.sba.wells.entity.Admin;
import com.sba.wells.model.AdminDAO;
import com.sba.wells.model.AdminDAOImp;

import java.io.PrintWriter; 

public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 PrintWriter out=response.getWriter();
		 System.out.println("Admin Filter enter");
		 		 String username = request.getParameter("username");
			String password =  request.getParameter("password");
			Admin check = new Admin(username,password);
			AdminDAO verify = (AdminDAO) new AdminDAOImp();
			try {
				boolean result = verify.verifyLogin(check);
				if(result) {
					System.out.println("Admin Filter done");
					request.setAttribute("Admin", username);

					chain.doFilter(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");  
				    rd.include(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
