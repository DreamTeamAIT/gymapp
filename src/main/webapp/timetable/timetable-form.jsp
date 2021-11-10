<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GYM APPLICATION</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
   <div>
    <a href="https://www.ait.ie" class="navbar-brand"> GYM
     App</a>
   </div>
   
   <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list"
     class="nav-link">Classes</a></li>
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
    <c:if test="${timetable != null}">
     <form action="updateTimetable" method="post"></form>
    </c:if>
    <c:if test="${timetable == null}">
     <form action="insertTimeTable" method="post"></form>
    </c:if>
    
     <caption>
     <h2>
      <c:if test="${timetable != null}">
               Edit Time Table
              </c:if>
      <c:if test="${timetable == null}">
               Add New Time Table
              </c:if>
     </h2>
    </caption>

    <c:if test="${timetable != null}">
     <input type="hidden" name="id" value="<c:out value='${timetable.id}' />" />
    </c:if>

    <fieldset class="form-group">
     <label>Time</label> <input type="text"
      value="<c:out value='${timetable.time}' />" class="form-control"
      name="time" required="required" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Instructor</label> <input type="text"
      value="<c:out value='${timetable.instructor}' />" class="form-control"
      name="instructor" minlength="5">
    </fieldset>
    
    <fieldset class="form-group">
     <label>Class</label> <input type="text"
      value="<c:out value='${timetable.myClass}' />" class="form-control"
      name="myClass" minlength="2">
    </fieldset>
    
    <button type="submit" class="btn btn-success">Save</button>
    </form>
   </div>
  </div>
 </div>

 <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>