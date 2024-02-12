<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News Agency</title>
</head>
<body>
<h3>
		<a href="/muthu-news-agency-bill-payer/admin/user/all?page=1">
			<button class="GFG">User home</button>
		</a>
	</h3>
 <div>
 <form action="deluser">
 	<label for="Mobile Number">Mobile Number</label>
 	<input type="text" name="mob" value="${mob}" required readonly/><br>
 	<input type="submit" value="DELETE"/>
 </form>
 
  <p>${errorMsg}</p>
</div>
</body>
</html>