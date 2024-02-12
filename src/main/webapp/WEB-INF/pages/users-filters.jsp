<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/users.css" rel="stylesheet" >
</head>
<body>
<div class="container">
	<h3>
		<a href="/muthu-news-agency-bill-payer/admin">
        <button class="GFG"> Home </button> 
    	</a>
    </h3>
    <h6>
     <a href="/muthu-news-agency-bill-payer/admin/user/all?page=1">
        <button class="GFG"> Users </button> 
    	</a>
    </h6>
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
			<th>S.No</th>
			<th>Mobile Number</th>
			<th>Name</th>
			<th>Region</th>
			<th>Papers Availed</th>
			<th>Amount</th>
			<th>Status</th>
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
			</tr>
		</c:forEach>
	</table>
	<%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
    	<span hidden="hidden">${count = count + 50}</span>
        <td><a href="?page=${currentPage - 1}">Previous</a></td>
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
        <td><a href="?page=${currentPage + 1}">Next</a></td>
    </c:if>
	</div>	
	</div>
</body>
</html>