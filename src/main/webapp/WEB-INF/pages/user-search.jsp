<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/userinfo.css" rel="stylesheet" >
</head>
<body>
<div class="container">
	<h2>Cutomer Details</h2>
	<div class="table-container">
	<p>${errorMsg}</p>
	<table>
		<tr>
			<th>Name</th>
			<td>${user.name}</td>
		</tr>
		<tr>
			<th>Mobile Number</th>
			<td>${user.mob}</td>
		</tr>
		<tr>
			<th>Papers Availed</th>
			<td>${user.papers}</td>
		</tr>
		<tr>
			<th>Papers Availed</th>
			<td>${user.reg}</td>
		</tr>
		<tr>
			<th>Bill</th>
			<td>${user.bill}</td>
		</tr>
		<tr>
			<th>Payment Status</th>
			<td>${user.status}</td>
		</tr>
		<tr>
			<th>Edit</th>
			<td><a href="/muthu-news-agency-bill-payer/admin/user/all/editPage/${user.mob}">Edit</a></td>
		</tr>
		<tr>
			<th>Delete</th>
			<td><a href="/muthu-news-agency-bill-payer/admin/user/all/delPage/${user.mob}">Delete</a></td>
		</tr>
	</table>
	</div>
	</div>
</body>
</html>