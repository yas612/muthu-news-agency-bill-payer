<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/home.css" rel="stylesheet">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/logo.png">
</head>
<body>
<%@ include file="header.jsp"%>
	<div class="container">
		<div class="left">
			<a href="/muthu-news-agency-bill-payer/loginpage" class="logo"><img
			src="${pageContext.request.contextPath}/resources/img/header-logo.png"
			alt="Logo" /></a>
		</div>
		<div class="right">
			<h2>About US</h2>
			<p>
				Muthu News Agency was founded by Muthiah back in 1954. Since, then the company serves 
				quality to its customers. The main agenda of the company is to deliver knowledge & 
				worldy insights through delivering NEWS PAPERS to its customer on a daily basis. 
				Even climatic conditions or deadly virus couldn't stop our service to our beloved customer. 
				We will look forward to serve the best of our to our customers.
			</p>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>