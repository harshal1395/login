<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img src="https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.underconsideration.com%2Fbrandnew%2Farchives%2Fbank_of_america_logo_white_on_red.png&imgrefurl=https%3A%2F%2Fwww.underconsideration.com%2Fbrandnew%2Farchives%2Fnew_logo_for_bank_of_america_by_lippincott.php&docid=DN0MQ09etiP44M&tbnid=fL0rc3cSKBIJzM%3A&vet=10ahUKEwiB5dqm4dTkAhVx73MBHWDYAWgQMwiDASgLMAs..i&w=2000&h=818&bih=657&biw=1366&q=bank%20of%20america&ved=0ahUKEwiB5dqm4dTkAhVx73MBHWDYAWgQMwiDASgLMAs&iact=mrc&uact=8"/>
<br>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<h3>
<%  
String name=request.getParameter("username");  
out.print("welcome "+name);  
%> 
</h3>

<a href="index.html">Home</a>

</body>
</html>