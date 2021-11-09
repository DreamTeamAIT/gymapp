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
					class="nav-link">Add instructor page</a></li>
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
			<h3 class="text-center">Instructors</h3>
			<hr>
			
			<br>
			<!--  <table class="table table-bordered">-->
				<tbody>
					<div align="center">
						<form action="<%=request.getContextPath()%>/insertInstructor"
							method="post">
							<table style="with: 100%">
								<tr>
									<td>Instructor Name</td>
									<td><input type="text" name="name" /></td>
								</tr>
								
								<tr>
									<td>Gender</td>
									<td><input type="text" name="gender" /></td>
								</tr>
								<tr>
									<td></td>
									
								</tr>
							</table>
							<button type="submit" class="btn btn-success">Add</button>
						</form>
						<!--  <input type="submit" value="Submit" />-->
					</div>
				
					
				</tbody>

			<!--</table>-->
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>