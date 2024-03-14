<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/edit-product.css" rel="stylesheet">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/logo.png">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h3>
			<a href="/muthu-news-agency-bill-payer/admin/product/all">
				<button class="main-page">செய்தித்தாள் முகப்பு பக்கம்</button>
			</a>
		</h3>
		<p>${errorMsg}</p>
		<div class="form-container">
			<form action="editProduct">

				<input type="hidden" name="code" value="${product.code}" required readonly /><br> 
				<label for="Name">செய்தித்தாள் பெயர்</label>
				<input type="text" name="name" value="${product.name}" required /><br>
				<label for="Price">செய்தித்தாள் விலை</label> 
				<input type="number" name="price" value="${product.price}" required /><br> 
				<input type="hidden" name="previousPrice" value="${product.price}" /> 
				<input type="submit" id="submit" value="மாற்று" />

			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>