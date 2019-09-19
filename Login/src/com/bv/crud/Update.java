package com.bv.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bv.products.ProductHandler;
import com.bv.products.Products;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");  
        out.print(n);
		int id1=Integer.parseInt(request.getParameter("id"));
		
		String productname=request.getParameter("productname");
		
		String manufacturername=request.getParameter("manufacturername");
		
		Double price=Double.parseDouble(request.getParameter("price"));
		Products products = new Products();
		products.setProductname(productname);
		products.setManufacturername(manufacturername);
		products.setPrice(price);
		products.setId(id1);
		
		int status = ProductHandler.updateProducts(products);
		if(status>0)
		{
			out.print("<h2>Records updated successfully!!!</h2>");
			out.print("<a href='display.jsp'>Home</a>");
		}
		else
		{
			out.print("Error! while updating the records");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
