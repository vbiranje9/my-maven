<%@page import="com.spr.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	List<Product> plist = (List<Product>)request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="index" >Back</a>
<table>
	<% for(Product p : plist){
		%>
		<tr>
			<td><%=p.getProductId()%></td>
			<td><%=p.getProductName()%></td>
			<td><%=p.getPrice()%></td>
			<td><a href="product_delete?productId=<%=p.getProductId()%>" >delete</a></td>
			<td><a href="product_update_form?productId=<%=p.getProductId()%>" >select</a></td>
		</tr>
		<%
	}
	%>
</table>
</body>
</html>