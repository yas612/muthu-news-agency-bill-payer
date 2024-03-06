<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/products.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %> 
<div class="container">
	<h3>
		<a href="/muthu-news-agency-bill-payer/admin">
        <button class="GFG"> முகப்பு பக்கம் </button> 
    	</a>
    </h3>
	<h6>
		<a href="all/addproductPage">
        <button class="GFG"> புதிய செய்தித்தாள் சேர்க்க </button> 
    	</a>
    </h6>
    	<p> ${erroMsg}</p>
	<table>
		<tr>
			<th>செய்தித்தாள் பெயர்</th>
			<th>செய்தித்தாள் விலை</th>
			<th>மாற்று</th>
			<th>அகற்று</th>
		</tr>
		<c:forEach var="product" items="${productlist}">
			<tr>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>
				<a href="all/editPage/${product.code}">
        			<button class="GFG"> மாற்று </button> 
    				</a>
    			</td>
    			<td><a href="all/delPage/${product.code}">
        			<button class="GFG"> அகற்று </button> 
    				</a>
    			</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<%@ include file="footer.jsp" %> 
</body>
</html>