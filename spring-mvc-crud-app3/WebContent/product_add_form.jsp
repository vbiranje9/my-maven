<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spr:form action="product_add" method="post" commandName="product" >
		Product Name : <spr:input path="productName" /><br>
		Price : <spr:input path="price" /><br>
		<input type="submit" value="Add" >
		<a href="index" >Back</a>
	</spr:form>
</body>
</html>