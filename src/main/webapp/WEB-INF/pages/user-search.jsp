<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/user-search.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %> 
<div class="container">
<h3>
		<a href="/muthu-news-agency-bill-payer/admin/user/all?page=1">
			<button class="GFG">பயனர் முகப்பு பக்கம்</button>
		</a>
	</h3>
	<h2>வாடிக்கையாளர் விவரங்கள்</h2>
	<div class="table-container">
	<p>${errorMsg}</p>
	<table>
		<tr>
			<th>பெயர்</th>
			<td>${user.name}</td>
		</tr>
		<tr>
			<th>கைபேசி எண்</th>
			<td>${user.mob}</td>
		</tr>
		<tr>
			<th>செய்தி தாள்கள்</th>
			<td>${user.papers}</td>
		</tr>
		<tr>
			<th>பகுதி</th>
			<td>${user.reg}</td>
		</tr>
		<tr>
			<th>பில் மதிப்பு</th>
			<td>${user.bill}</td>
		</tr>
		<tr>
			<th>பில் நிலை</th>
			<td>${user.status}</td>
		</tr>
		<tr>
			<th>மாற்று</th>
			  <td>
				<a href="/muthu-news-agency-bill-payer/admin/user/all/editPage/${user.mob}">
       				 <button class="GFG"> மாற்று </button> 
    			</a>
    		   </td>
		</tr>
		<tr>
			<th>அகற்று</th>
			<td>
				<a href="/muthu-news-agency-bill-payer/admin/user/all/delPage/${user.mob}">
       				 <button class="GFG"> அகற்று </button> 
    			</a>
    		 </td>
		</tr>
	</table>
	</div>
	</div>
	<%@ include file="footer.jsp" %> 
</body>
</html>