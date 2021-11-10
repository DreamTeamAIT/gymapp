<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Account</title>
<jsp:include page="../common/header.jsp"></jsp:include>
</head>

<body>
 <div align="center">
  <h1>Delete Customer Account</h1>
  <form action="<%= request.getContextPath() %>/a" method="post">
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
     <td>Error Log</td>
     <td><input type="text" name="errorLog" readonly/></td>
    </tr>
   </table>
   <input type="submit" value="Delete" />
  </form>
 </div>
 <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>