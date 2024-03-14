<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/logo.png">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h3>வணக்கம் மேலாளர்</h3>
		<span> 
			<a href="admin/user/all?page=1">
				<button class="GFG">பயனர்கள்</button>
			</a>
		</span> 
		<span> 
			<a href="admin/product/all">
				<button class="GFG">செய்தி தாள்கள்</button>
			</a>
		</span> 
		<span> 
			<a href="admin/user/all/reset/page">
				<button class="GFG">அனைத்து பயனர்களின் பில் நிலை மாற்றம்</button>
			</a>
		</span>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>