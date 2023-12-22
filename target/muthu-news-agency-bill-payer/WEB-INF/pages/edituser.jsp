<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News</title>
</head>
<body>
<h3><a href="/Muthu-News-Bill-Payer/admin/user/all"><span>User Home</span></a></h3>

	<form action="edituser">
		
		<label for="Mobile Number">Mobile Number</label>
		<input type="text" name="mob" value="${user.mob}" required/><br>
		<label for="Name">Name</label>
		<input type="text" name="name" value="${user.name}" required/><br>
		<label for="Region">Region</label>
		<input type="text" name="reg" value="${user.reg}" required /><br>
		<label for="Papers">Papers</label>
		<input type="text" name="papers" value="${user.papers}" required /><br>
		<label for="Bill Value">Bill Value</label>
		<input type="number" name="bill" value="${user.bill}" step="any" required /><br>
		<input type="submit" value="Update" />
		
	</form>

</body>
</html>