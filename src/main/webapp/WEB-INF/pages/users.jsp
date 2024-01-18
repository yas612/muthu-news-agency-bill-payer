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
	<h1> ${erroMsg}</h1>
	<h3><a href="/muthu-news-agency-bill-payer/admin"><span>Home</span></a></h3>
	<h6><a href="all/adduserPage"><span>Add User</span></a></h6>
	<table>
		<tr>
			<th>Mobile Number</th>
			<th>Name</th>
			<th>Region</th>
			<th>Papers Availed</th>
			<th>Amount</th>
			<th>Status</th>
		</tr>
		<c:forEach var="user" items="${userlist}">
			<tr>
				<td>${user.mob}</td>
				<td>${user.name}</td>
				<td>${user.reg}</td>
				<td>${user.papers}</td>
				<td>${user.bill}</td>
				<td>${user.status}</td>
				<td><a href="all/editPage/${user.mob}">Edit</a></td>  
				<td><a href="all/delPage/${user.mob}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>