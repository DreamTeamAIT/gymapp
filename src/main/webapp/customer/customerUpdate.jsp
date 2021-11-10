<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer Details</title>
<jsp:include page="../common/header.jsp"></jsp:include>
</head>
<body>
 <div align="center">
  <h1>Customer Update Form</h1>
  <h2>Enter new elements to update. Leave blank to not update. Enter id to confirm identity.</h2>
  <form action="<%= request.getContextPath() %>/updateCustomer" method="post">
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
   <input type="submit" value="Update" />
  </form>
 </div>
   <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>