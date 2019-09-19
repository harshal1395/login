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
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public View() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int size = 0;

		PrintWriter out = response.getWriter();
		String n="Hello Jack";
		 HttpSession session=request.getSession();  
	      session.setAttribute("uname",n);  
		List<Products> list = ProductHandler.getAllProducts();
		out.print("<h4>Product Details</h4>");
		out.print(
				"<table border='5' align='center' color=''><tr><td>ID</td><td>PRODUCTNAME</td><td>MANUFACTURERNAME</td><td>PRICE</td></tr>");
		while (size < list.size()) {
			int id1 = list.get(size).getId();
			String productname = list.get(size).getProductname();
			String manufacturername = list.get(size).getManufacturername();
			double price = list.get(size).getPrice();

			out.print("<tr><td>" + id1 + "</td>");
			out.print("<td>" + productname + "</td>");
			out.print("<td>" + manufacturername + "</td>");
			out.print("<td>" + price + "</td>");
			out.print("<td><a href= 'EditServlet?id2=" + list.get(size).getId() + "'>Update</a></td>");
			out.print("<td><a href= \" delete.html\">Delete</a></td></tr>");

			size++;
		}
		out.print("</table>");
		out.print("           <a href='display.jsp'>Home</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
