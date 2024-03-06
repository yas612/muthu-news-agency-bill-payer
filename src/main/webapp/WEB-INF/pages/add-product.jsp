<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/add-product.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %> 
<div class="container">
	<h3>
	<a href="/muthu-news-agency-bill-payer/admin/product/all">
        <button class="GFG"> செய்தித்தாள் முகப்பு பக்கம் </button> 
    </a>
	</h3>
	<p>${errorMsg}</p>
	<div class="form-container">
		<form  action="addProduct">
			<label for="Product Code">செய்தித்தாள் குறியீடு</label> 
			<input type="text" name="code" required /><br> 
			<label for="Name">செய்தித்தாள் பெயர்</label> 
			<input type="text" name="name" required /><br> 
			<label for="Price">செய்தித்தாள் விலை</label>
			<input type="number" name="price" required /><br> 
			<input type="submit" id="submit" value="செய்தி தாள் சேர்" />
		</form>
	</div>
	</div>
	<%@ include file="footer.jsp" %> 
</body>
</html>