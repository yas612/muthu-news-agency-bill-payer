<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" >
</head>
<body>
<div class="form-center">
 <div class="form-box">	
  <p> ${errorMsg}</p>
	<form action="login">
		<label for="mob">Enter your Mobile Number</label><br>
		<input type="text" name="mob" required/><br>
		<input type="submit" />
	</form>
 </div>
</div>	
</body>
</html>