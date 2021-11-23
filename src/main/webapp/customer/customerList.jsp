<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>User Management Application</title>
	
	<link rel="stylesheet"
	 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	 crossorigin="anonymous">
</head>
<header>
	<jsp:include page="../common/header.jsp"></jsp:include>
</header>
<body>
 <div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
   <h3 class="text-center">List of Customers</h3>
   <hr>
   <div class="container text-left">

    <a href="<%=request.getContextPath()%>/newCustomer"
     class="btn btn-success">Add Customer</a>
   </div>
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
     <th>ID</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>password</th>
      <th>email</th>
     </tr>
    </thead>
    <tbody>
     <!--   for (Todo todo: todos) {  -->
     <c:forEach var="customer" items="${listCustomer}">

      <tr>
      <td><c:out value="${customer.id}" /></td>
       <td><c:out value="${customer.firstName}" /></td>
       <td><c:out value="${customer.lastName}" /></td>
       <td><c:out value="${customer.password}" /></td>
       <td><c:out value="${customer.email}" /></td>

       <td><a href="editCustomer?id=<c:out value='${customer.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="deleteCustomer?id=<c:out value='${customer.id}' />">Delete</a></td>

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