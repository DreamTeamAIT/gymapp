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
  <nav class="navbar navbar-expand-md navbar-dark"
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
  </nav>
 </header>
 <div class="container col-md-5">
  <div class="card">
   <div class="card-body">
    <c:if test="${classes != null}">
     <form action="update" method="post">
    </c:if>
    <c:if test="${classes == null}">
     <form action="insert" method="post">
    </c:if>
    
     <caption>
     <h2>
      <c:if test="${classes != null}">
               Edit Classes
              </c:if>
      <c:if test="${classes == null}">
               Add New Classes
              </c:if>
     </h2>
    </caption>

    <c:if test="${classes != null}">
     <input type="hidden" name="classID" value="<c:out value='${classes.classID}' />" />
    </c:if>

    <fieldset class="form-group">
     <label>Class Title</label> <input type="text"
      value="<c:out value='${classes.classname}' />" class="form-control"
      name="classname" required="required" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Class Instructor</label> <input type="text"
      value="<c:out value='${classes.instructor}' />" class="form-control"
      name="instructor" minlength="5">
    </fieldset>
    
      <fieldset class="form-group">
     <label>Class Time</label> <input type="text"
      value="<c:out value='${classes.classtime}' />" class="form-control"
      name="classtime" minlength="5">
    </fieldset>
    
    <button type="submit" class="btn btn-success">Save</button>
    </form>
   </div>
  </div>
 </div>

 <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
   