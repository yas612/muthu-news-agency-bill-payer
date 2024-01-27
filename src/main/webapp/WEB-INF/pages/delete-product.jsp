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
<form action="delProduct">
 	<label for="Product Code">Code</label>
 	<input type="text" name="code" value="${code}" required readonly /><br>
 	<input type="submit" value="DELETE"/>
 </form>
 
  <p>${errorMsg}</p>
</body>
</html>