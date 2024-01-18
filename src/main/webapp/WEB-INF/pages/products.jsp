<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News Agency</title>
</head>
<body>
	<h3><a href="/muthu-news-agency-bill-payer/admin"><span>Home</span></a></h3>
	<h6><a href="all/addproductPage"><span>Add Product</span></a></h6>
	<table>
		<tr>
			<th>Product Code</th>
			<th>Product Name</th>
			<th>Product Price</th>
		</tr>
		<c:forEach var="product" items="${productlist}">
			<tr>
				<td>${product.code}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td><a href="all/editPage/${product.code}">Edit</a></td>  
				<td><a href="all/delPage/${product.code}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<h1> ${erroMsg}</h1>
</body>
</html>