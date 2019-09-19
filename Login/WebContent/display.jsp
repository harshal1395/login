<%@ page  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@page import="java.util.List"%>
<%@page import="com.bv.products.Products"%>
<%@page import="com.bv.products.ProductHandler"%>
 
 <%
 	
 List<Products> ulist = ProductHandler.getAllProducts();
 	
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="View">

				<table>
				<tr>
						<td><a href= " products.html">Add Product</a></td>
					</tr>
					<tr>
						<td><a href= " getbyid.html">View By ID</a></td>
					</tr>
					<tr>
						<td><input type="submit" value ="ViewProducts"></td>
					</tr>
				</table>
				</form>
</body>
</html>
