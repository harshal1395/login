package com.bv.crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bv.products.ProductHandler;
import com.bv.products.Products;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");  
        out.print(n);
        String sid=request.getParameter("id2");  
        int id=Integer.parseInt(sid);  
          
        Products e=ProductHandler.getProductById(id);
          
        out.print("<form action='Update' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='productname' value='"+e.getProductname()+"'/></td></tr>");  
/*//        out.print("<tr><td>MANFACT:</td><td><input type='text' name='manufacturername' value='"+e.getManufacturername()+"'/></td></tr>");  
//        
//       out.print("<tr><td>Country:</td><td>");  
*/        out.print("<select name='manufacturername' value="+e.getManufacturername()+" style='width:150px'>");  
        out.print(" <option>---select---</option>");  
        out.print("<option>Apple</option>");  
        out.print("<option>Samsung</option>");  
        out.print("<option>MI</option>");  
        out.print("<option>Vivo</option>");  
        out.print("<option>Oppo</option>");  
        out.print("<option>OnePlus</option>");  
        out.print("<option>Sony</option>");  
        out.print("<option>Other</option>");  
        out.print("<tr><td>Price:</td><td><input type='text' name='price' value='"+e.getPrice()+"'/></td></tr>");  
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
