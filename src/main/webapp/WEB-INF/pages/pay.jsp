<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%--<%@ page import ="com.muthu.news.controller.PaymentController, com.razorpay.Order" %>  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/pay.css" rel="stylesheet">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/logo.png">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h3>
			<a href="/muthu-news-agency-bill-payer/loginpage">
				<button id="main-page">முகப்பு பக்கம்</button>
			</a>
		</h3>
		<div class="pay-container">
			<p id="pay-tick">✅</p>
			<p id="pay-suc">Payment Successful !</p>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>