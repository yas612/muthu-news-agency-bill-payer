<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News Agency</title>
</head>
<body>
<h3>
	<a href="/muthu-news-agency-bill-payer/admin/product/all">
        <button class="GFG"> Paper Home </button> 
    </a>
	</h3>
<form action="editProduct">
		
		<label for="Product Code">Code</label>
		<input type="text" name="code" value="${product.code}" required readonly /><br>
		<label for="Name">Name</label>
		<input type="text" name="name" value="${product.name}" required/><br>
		<label for="Price">Price</label>
		<input type="number" name="price" value="${product.price}" required /><br>
		<input type="hidden" name="previousPrice" value="${product.price}" />
		<input type="submit" value="Update" />
		
	</form>
	<p>${errorMsg}</p>
</body>
</html>