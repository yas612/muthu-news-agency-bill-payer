<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/users.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %> 
<div class="container">
	<h6>
		<a href="/muthu-news-agency-bill-payer/admin">
        <button class="GFG"> முகப்பு பக்கம் </button> 
    	</a>
    </h6>
	<h6>
		<a href="all/adduserPage">
        <button class="GFG"> புதிய பயனரைச் சேர்க்கவும் </button> 
    	</a>
    </h6>
    <form action="search/user">
      <input type="text" placeholder="தேடு.." name="mob" required>
      <button type="submit">தேடு</button>
    </form>
    <br>
    <form action="filter/filters">
		<select name="params" multiple required>
			<option value="PAID">PAID</option>
			<option value="NOT-PAID">NOT-PAID</option>
			<c:forEach var="region" items="${reg}">
				<option value="${region}FKUY">${region}</option>
			</c:forEach>
			<c:forEach var="product" items="${products}">
				<option value="${product.code}ZJXT">${product.code}</option>
			</c:forEach>
		</select><br>
		<button class="GFG"> Filter </button>
		</form>
    <%
		int count = 0;
	%>
	<c:if test="${currentPage == 1}">
    	<span hidden="hidden">${count=0}</span>
    	</c:if>
    	<c:if test="${currentPage != 1}">
    	<span hidden="hidden">${count= 50*(currentPage - 1)}</span>
    	</c:if>
    <div class="table-container">
    <p>${erroMsg}</p>
	<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<th>வரிசை எண்</th>
			<th>கைபேசி எண்</th>
			<th>பெயர்</th>
			<th>பகுதி</th>
			<th>வாங்கப்பட்ட செய்தித் தாள்கள்</th>
			<th>பில் மதிப்பு</th>
			<th>பணம் செலுத்தப்பட்டது <br>ஆம்/இல்லை</th>
			<th>மாற்று</th>
			<th>அகற்று</th>
		</tr>
		<c:forEach var="user" items="${userlist}">
			<tr>
				<td>${count = count+1}</td>
				<td>${user.mob}</td>
				<td>${user.name}</td>
				<td>${user.reg}</td>
				<td>${user.papers}</td>
				<td>${user.bill}</td>
				<td>${user.status}</td>
				<td><a href="all/editPage/${user.mob}">
        			<button class="GFG"> மாற்று </button> 
    				</a>
    			</td>
    			<td><a href="all/delPage/${user.mob}">
        			<button class="GFG"> அகற்று </button> 
    				</a>
    			</td>
			</tr>
		</c:forEach>
	</table>
	<%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
    	<span hidden="hidden">${count = count + 50}</span>
    	<td><a href="?page=${currentPage - 1}">
        	<button class="GFG"> முந்தைய பக்கம் </button> 
    		</a>
    	</td>
    </c:if>
 
    <%--For displaying Page numbers. 
    The when condition does not display a link for the current page
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table> --%>
     
    <%--For displaying Next link --%>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="?page=${currentPage + 1}">
        	<button class="GFG"> அடுத்த பக்கம் </button> 
    		</a>
    	</td>
    </c:if>
	</div>	
	</div>
	<%@ include file="footer.jsp" %> 
</body>
</html>