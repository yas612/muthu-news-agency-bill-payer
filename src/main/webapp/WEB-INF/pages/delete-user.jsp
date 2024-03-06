<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/delete-user.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %> 
<div class="container">
<h3>
		<a href="/muthu-news-agency-bill-payer/admin/user/all?page=1">
			<button class="GFG">பயனர் முகப்பு பக்கம்</button>
		</a>
	</h3>
	<p>${errorMsg}</p>
 <div>
 <form class ="form-container" action="deluser">
 	<label for="Mobile Number">கைபேசி எண்</label>
 	<input type="text" name="mob" value="${mob}" required readonly/><br>
 	<input type="submit" id="submit" value="அகற்று"/>
 </form>
  </div>
</div>
  <%@ include file="footer.jsp" %> 
</body>
</html>