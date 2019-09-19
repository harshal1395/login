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
 * Servlet implementation class byId
 */
@WebServlet("/byId")
public class byId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public byId() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");  
        out.print(n);
		int id = Integer.parseInt(request.getParameter("id"));
		List<Products> list = ProductHandler.getAllProducts();

		int size = 0;
		while (size < list.size()) {
			int id1 = list.get(size).getId();
			String productname = list.get(size).getProductname();
			String manufacturername = list.get(size).getManufacturername();
			double price = list.get(size).getPrice();
			if (id1 == id) {
				out.print("<h4>Product Details</h4>");
				out.print(
						"<table border='5' align='center' color=''><tr><td>ID</td><td>PRODUCTNAME</td><td>MANUFACTURERNAME</td><td>PRICE</td></tr>");
				out.print("<tr><td>" + id + "</td>");
				out.print("<td>" + productname + "</td>");
				out.print("<td>" + manufacturername + "</td>");
				out.print("<td>" + price + "</td>");
				out.print("<td><a href= \" products.html\">Update</a></td>");
				out.print("<td><a href= \" delete.html\">Delete</a></td></tr>");
				out.print("</table>");
				out.print("<a href= \" products.html\" style=\"float: right;\">Add Product</a>");
				break;
			}
			size++;
		}

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
