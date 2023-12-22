<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News</title>
</head>
<body>
<h3><a href="/muthu-news-agency-bill-payer/admin/user/all"><span>User Home</span></a></h3>
<div>
<form action="adduser">
		
		<label for="Mobile Number">Mobile Number</label>
		<input type="text" name="mob" required/><br>
		<label for="Name">Name</label>
		<input type="text" name="name" required/><br>
		<label for="Region">Region</label>
		<input type="text" name="reg" required /><br>
		<label for="Papers">Papers</label>
		<input type="text" name="papers" required /><br>
		<label for="Bill Value">Bill Value</label>
		<input type="number" name="bill" required /><br>
		<input type="submit" value="ADD" />
		
	</form>
	<p>${msg}</p>
	</div>
</body>
</html>