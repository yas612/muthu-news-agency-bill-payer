<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News Agency</title>
</head>
<body>
<h3>
		<a href="/muthu-news-agency-bill-payer/admin/user/all?page=1">
			<button class="GFG">User home</button>
		</a>
	</h3>
<div>
<form action="adduser">
		
		<label for="Mobile Number">Mobile Number</label>
		<input type="text" name="mob" required/><br>
		<label for="Name">Name</label>
		<input type="text" name="name" required/><br>
		<label for="Region">Region</label>
		<input type="text" name="reg" required /><br>
		<label for="Papers">Papers</label><br>
		<select name="papers" multiple>
			<c:forEach var="product" items="${productlist}">
    			<option value="${product.code}">${product.name}</option>
    		</c:forEach>
  		</select><br>
		<label for="Bill Value">Bill Value</label>
		<input type="number" name="bill" required /><br>
		<input type="submit" value="ADD" />
		
	</form>
	<p>${errorMsg}</p>
	</div>
</body>
</html>