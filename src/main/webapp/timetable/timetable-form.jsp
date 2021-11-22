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
				<a href="https://www.javaguides.net" class="navbar-brand"> GYM
					App</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">GYM</a></li>
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
					<form action="updateTimetable" method="post">
				</c:if>
				<c:if test="${timetable == null}">
					<form action="insertTimetable" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${timetable != null}">   Edit TT </c:if>
						
						<c:if test="${timetable == null}">   Add New TT </c:if>
					</h2>
				</caption>

				<c:if test="${timetable != null}">
					<input type="hidden" name="id" value="<c:out value='${timetable.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>TimeTable Time</label> <input type="text"
						value="<c:out value='${timetable.time}' />" class="form-control"
						name="time" required="required" minlength="5">
				</fieldset>
				
				<fieldset class="form-group">
					<label>TimeTable myClass</label> <input type="text"
						value="<c:out value='${timetable.myClass}' />" class="form-control"
						name="myClass" required="required" minlength="5">
				</fieldset>
				
				<fieldset class="form-group">
					<label>TimeTable instructor</label> <input type="text"
						value="<c:out value='${timetable.instructor}' />" class="form-control"
						name="instructor" required="required" minlength="5">
				</fieldset>


				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>