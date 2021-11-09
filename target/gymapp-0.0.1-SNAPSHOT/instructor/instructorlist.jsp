<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Instructor list</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 
 

</head>

</head>
<body>
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
   <div>
    <a href="https://www.javaguides.net" class="navbar-brand"> Gym
     App</a>
   </div>

    		 <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list"
     class="nav-link">Classes</a></li>
   </ul>
   
    <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/instructorList"
     class="nav-link">Instructors</a></li>
   </ul>
   
   <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/timetableList"
     class="nav-link">Timetable</a></li>
   </ul>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>

 <div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
   <h3 class="text-center">List of Instructors</h3>
   <hr>
   <div class="container text-left">

    <a href="<%=request.getContextPath()%>/newInstructor"
     class="btn btn-success">Add Instructor</a>
   </div>
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
      <th>Name</th>
      <th>Gender</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <!--   for (Todo todo: todos) {  -->
     <c:forEach var="instructor" items="${listInstructors}">

      <tr>
       <td><c:out value="${instructor.name}" /></td>
       <td><c:out value="${instructor.gender}" /></td>

       <td><a href="editInstructor?id=<c:out value='${instructor.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="deleteInstructor?id=<c:out value='${instructor.id}' />">Delete</a></td>

      <!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
                 <button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> --> 
      </tr>
     </c:forEach>
     <!-- } -->
    </tbody>

   </table>
  </div>
 </div>

 <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>