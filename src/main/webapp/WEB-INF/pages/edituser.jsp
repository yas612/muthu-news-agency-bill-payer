<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/edituser.css" rel="stylesheet" >
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/logo.png">
</head>
<body>
<%@ include file="header.jsp" %> 
<div class="container">
	<h3>
		<a href="/muthu-news-agency-bill-payer/admin/user/all?page=1">
			<button class="main-page">பயனர் முகப்பு பக்கம்</button>
		</a>
	</h3>
	<p>${errorMsg}</p>
	<form class="form-container" action="edituser">

		<label for="Mobile Number">கைபேசி எண் : </label> 
		<input type="text" name="mob" value="${user.mob}" required readonly /><br> 
		<label for="Name">பெயர் : </label> 
		<input type="text" name="name" value="${user.name}" required /><br> 
		<label for="Region">பகுதி : </label>
		<input type="text" name="reg" value="${user.reg}" required /><br>
		<label for="Current Papers">செய்தித் தாள்கள் வாங்கப்பட்டன : </label><br>
		<textarea name="papers" rows="5" cols="80" readonly>${user.papers}</textarea><br> 
		<label for="Papers">செய்தித்தாள் திருத்த : </label><br> 
		<select name="updatedPapers" id="paper" multiple>
			<c:forEach var="product" items="${productlist}">
				<option value="${product.code}">${product.name}</option>
			</c:forEach>
		</select><br> 
		<label for="Bill Value">பில் மதிப்பு : </label> 
		<input type="number" name="bill" value="${user.bill}" step="any" required /><br>
		<label for="Bill Status">பில் நிலை : </label> <br>
		<select name="status">
			<option value="PAID">PAID</option>
			<option value="NOT-PAID" selected="selected">NOT-PAID</option>
		</select><br>
		<input class="submit-btn" type="submit" id="submit" value="மாற்று" />

	</form>
	</div>
<%@ include file="footer.jsp" %> 
</body>
</html>