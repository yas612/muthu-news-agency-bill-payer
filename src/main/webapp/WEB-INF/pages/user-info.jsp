<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News Agency</title>
</head>
<body>
	<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
	<script src="<c:url value="/resources/js/pay.js" />"></script>

	<h1>Customer Detail</h1>
	<p>Name is : ${user.name}</p>
	<p>Mobile Number is : ${user.mob}</p>
	<p>Papers Availed : ${user.papers}</p>
	<p>Amount : ${user.bill}</p>
	<p>Payment Status : ${user.status}</p>
	<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
	<script src="<c:url value="/resources/js/pay.js" />"></script>
	<button id="rzp-button1" value="Pay" ${decider} onclick="createOrderId('${user.bill}', '${user.mob}', '${url}')"></button>
</body>
</html>