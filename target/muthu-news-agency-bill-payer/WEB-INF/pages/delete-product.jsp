<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News</title>
</head>
<body>
<h3><a href="/Muthu-News-Bill-Payer/admin/product/all"><span>Product Home</span></a></h3>
<form action="delProduct">
 	<label for="Product Code">Code</label>
 	<input type="text" name="code" value="${code}" required /><br>
 	<input type="submit" value="DELETE"/>
 </form>
 
  <p>${msg}</p>
</body>
</html>