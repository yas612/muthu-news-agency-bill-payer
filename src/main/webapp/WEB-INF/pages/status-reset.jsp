<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/status-reset.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %> 
<div class="container">
<span>
<a href="/muthu-news-agency-bill-payer/admin"> 
        <button class="GFG"> முகப்பு பக்கம் </button> 
</a> 
</span>
<p>${errorMsg}</p>
<span>
<a href='status'> 
        <button class="GFG"> அனைத்து பயனர்களின் பில் நிலை மாற்றம் </button> 
</a> 
</span>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>