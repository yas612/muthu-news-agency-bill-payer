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
	<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
	<script src="<c:url value="/resources/js/pay.js" />"></script>

<div class="container">
	<h2>Cutomer Details</h2>
	<div class="table-container">
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
			<th>Bill</th>
			<td>${user.bill}</td>
		</tr>
		<tr>
			<th>Payment Status</th>
			<td>${user.status}</td>
		</tr>
	</table>
	</div><br>
	<button id="rzp-button1" value="Pay" ${decider} onclick="createOrderId('${user.bill}', '${user.mob}', '${url}')">Pay</button>
	</div>
</body>
</html>