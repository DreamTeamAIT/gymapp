<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>GYM Application</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">

</head>

</head>
<body>
 <header>
  <%-- <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
   <div>
    <a href="https://www.ait.ie" class="navbar-brand"> GYM
     App</a>
   </div>
   
   <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list"
     class="nav-link">Todos</a></li>
   </ul>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav> --%>
  <jsp:include page="../common/header.jsp"></jsp:include>
 </header>
 <div class="container col-md-5">
  <div class="card">
   <div class="card-body">
    <c:if test="${instructor != null}">
     <form action="updateInstructor" method="post">
    </c:if>
    <c:if test="${instructor == null}">
     <form action="insertInstructor" method="post">
    </c:if>
    
     <caption>
     <h2>
      <c:if test="${instructor != null}">
               Edit Instructor
              </c:if>
      <c:if test="${instructor == null}">
               Add New Instructor
              </c:if>
     </h2>
    </caption>

    <c:if test="${instructor != null}">
     <input type="hidden" name="id" value="<c:out value='${instructor.id}' />" />
    </c:if>

    <fieldset class="form-group">
     <label>Instructor Name</label> <input type="text"
      value="<c:out value='${instructor.name}' />" class="form-control"
      name="name" required="required" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Instructor Gender</label> <input type="text"
      value="<c:out value='${instructor.gender}' />" class="form-control"
      name="gender" minlength="5">
    </fieldset>
    
    <button type="submit" class="btn btn-success">Save</button>
    </form>
   </div>
  </div>
 </div>

 <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>