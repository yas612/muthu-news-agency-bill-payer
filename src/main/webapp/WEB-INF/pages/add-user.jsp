<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/add-user.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %> 
<div class="container">
<h3>
		<a href="/muthu-news-agency-bill-payer/admin/user/all?page=1">
			<button id="user-main" >பயனர் முகப்பு பக்கம்</button>
		</a>
	</h3>
<div>
<form class="form-container" action="adduser">
		
		<label for="Mobile Number">கைபேசி எண்</label>
		<input type="text" name="mob" id="mob" maxlength="10" minlength="10" required/><br>
		<label for="Name">பெயர்</label>
		<input type="text" name="name" required/><br>
		<label for="Region">பகுதி</label>
		<input type="text" name="reg" required /><br>
		<label for="Papers">செய்தி தாள்கள்</label><br>
		<select name="papers" multiple required>
			<c:forEach var="product" items="${productlist}">
    			<option value="${product.code}">${product.name}</option>
    		</c:forEach>
  		</select><br>
		<label for="Bill Value">பில் மதிப்பு</label>
		<input type="number" name="bill" required /><br>
		<input type="submit" id="submit" value="சேரு" />
		
	</form>
	<p>${errorMsg}</p>
	</div>
	</div>
	<%@ include file="footer.jsp" %> 
</body>
</html>