<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%--<%@ page import ="com.muthu.news.controller.PaymentController, com.razorpay.Order" %>  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<%@ include file="header.jsp" %> 
</head>
<body>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script src="<c:url value="/resources/js/pay.js" />"></script>
<button id="rzp-button1" onclick="createOrderId()">Pay</button>
<%@ include file="footer.jsp" %> 
</body>
</html>