<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Deleted Successfully</title>
<jsp:include page="../common/header.jsp"></jsp:include>
</head>
<body>
<form action="<%= request.getContextPath() %>/customerDelete" method="post">
	<h1>Account succcessfully deleted</h1>
	</form>
</body>
  <jsp:include page="../common/footer.jsp"></jsp:include>
</html>