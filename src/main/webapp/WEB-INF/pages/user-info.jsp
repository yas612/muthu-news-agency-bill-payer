<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script src="<c:url value="/resources/js/pay.js" />"></script>
<link href="${pageContext.request.contextPath}/resources/css/userinfo.css" rel="stylesheet">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/logo.png">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h4>வாடிக்கையாளர் விவரங்கள்</h4>
		<div class="form-container">
			<form action="edituser">

				<label for="Mobile Number">கைபேசி எண் : </label> 
				<input type="text" name="mob" value="${user.mob}" required readonly /><br> 
				<label for="Name">பெயர் : </label> 
				<input type="text" name="name" value="${user.name}" required readonly /><br> 
				<label for="Current Papers">வாங்கப்பட்ட</label><br> 
				<label for="Current Papers">செய்தித் தாள்கள் : </label><br>
				<textarea name="papers" rows="5" cols="80" readonly>${user.papers}</textarea><br> 
				<label for="Bill Value">பில் மதிப்பு : </label> 
				<input type="number" name="bill" value="${user.bill}" step="any" required readonly /><br> 
				<label for="Bill Status">பில் நிலை :</label> 
				<input type="text" name="status" value="${user.status}" step="any" required readonly /><br>

			</form>
			<br>
		</div>
		<button id="rzp-button1" class="submit" value="Pay" ${decider}
			onclick="createOrderId('${user.bill}', '${user.mob}', '${url}')">Pay</button>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>