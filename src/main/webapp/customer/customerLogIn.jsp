<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="../common/header.jsp"></jsp:include>
</head>
<body>
 <div align="center">
  <h1>Customer Log-in Form</h1>
  <form action="<%= request.getContextPath() %>/logIn" method="post">
   <table style="with: 80%">
   <tr>
     <td>Email Address</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr> 
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
  <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>