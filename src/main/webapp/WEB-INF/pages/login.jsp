<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" >

</head>
<body>
<div class="form-center">
 <div class="form-box">
  <p> ${errorMsg}</p>
	<form action="login">
		<label for="mob" class="desc">Enter your Mobile Number</label><br>
		<input type="text" name="mob" required/><br>
		<input type="submit" class="button"/>
	</form>
 </div>
</div>	
</body>
</html>