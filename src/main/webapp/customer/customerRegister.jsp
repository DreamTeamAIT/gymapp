<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	 crossorigin="anonymous">
	 <jsp:include page="../common/header.jsp"></jsp:include>
</head>
<body>
 <div align="center">
  <h1>Customer Register Form</h1>
  <form action="<%= request.getContextPath() %>/insertCustomer" method="post">
   <table style="with: 80%">
    <tr>
     <td>First Name</td>
     <td><input type="text" name="firstName" /></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastName" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Email Address</td>
     <td><input type="text" name="email" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
  <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>