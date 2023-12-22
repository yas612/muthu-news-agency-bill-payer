<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muthu News</title>
</head>
<body>
 <h1>Customer Detail</h1>
  <p>Name is 		  : ${user.name}</p>
  <p>Mobile Number is : ${user.mob}</p>
  <p>Papers Availed   : ${user.papers}</p>
  <p>Amount  		  : ${user.bill}</p>
  <p>Payment Status   : ${user.status}</p>
  <form>
   <input type="submit" value="Pay ${user.bill}" ${decider} />
  </form>
</body>
</html>