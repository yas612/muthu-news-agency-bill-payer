<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/delete-product.css" rel="stylesheet" >
<%@ include file="header.jsp" %> 
</head>
<body>
<div class="container">
<h3>
	<a href="/muthu-news-agency-bill-payer/admin/product/all">
        <button class="GFG"> செய்தித்தாள் முகப்பு பக்கம் </button> 
    </a>
	</h3>
	 <p>${errorMsg}</p>
	<div class="form-container" >
<form action="delProduct">
 	<label for="Product Code">செய்தித்தாள் பெயர்</label>
 	<input type="hidden" name="code" value="${code}" required readonly /><br>
 	<input type="text" name="name" value="${name}" required readonly /><br>
 	<input type="submit" id="submit" value="அகற்று"/>
 </form>
 </div>
  </div>
  <%@ include file="footer.jsp" %> 
</body>
</html>