<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/logo.png">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="form-center">
		<p>${errorMsg}</p>
		<div class="form-box">
			<form action="login">
				<label for="mob" class="desc">உங்களுடைய கைபேசி எண்ணை நிரப்பக</label><br>
				<input type="text" name="mob" maxlength="10" minlength="10" required /><br>
				<input type="submit" id="submit" class="button" />
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>