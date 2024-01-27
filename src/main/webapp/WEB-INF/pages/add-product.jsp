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
	<div>
		<form action="addProduct">
			<label for="Product Code">Code</label> <input type="text" name="code"
				required /><br> <label for="Name">Name</label> <input
				type="text" name="name" required /><br> <label for="Price">Price</label>
			<input type="number" name="price" required /><br> <input
				type="submit" value="ADD" />
		</form>
		<p>${errorMsg}</p>
	</div>
</body>
</html>