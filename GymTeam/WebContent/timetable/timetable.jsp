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

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
        <div class="container">

            <h2>New TimeTable</h2>
            <div class="col-md-6 col-md-offset-3">
                <div class="alert alert-success center" role="alert">
                    <p>${NOTIFICATION}</p>
                </div>

                <form action="<%=request.getContextPath()%>/addTimeTable" method="post">

                    <div class="form-group">
                        <label for="uname">My Time:</label> <input type="text" class="form-control" id="myTime" placeholder="my Time" name="myTime" required>
                    </div>

                    <div class="form-group">
                        <label for="uname">My Class:</label> <input type="text" class="form-control" id="myClass" placeholder="my class" name="myClass" required>
                    </div>

                    <div class="form-group">
                        <label for="uname">Instructor:</label> <input type="text" class="form-control" id="instructor" placeholder="instructor" name="instructor" required>
                    </div>

                    
                    <button type="submit" class="btn btn-primary">Submit</button>

                </form>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"></jsp:include>
				
</body>
</html>