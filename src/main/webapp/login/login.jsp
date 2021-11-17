<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Gym App Login Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
	<header>
		  <nav class="navbar navbar-expand-md navbar-dark"
			   style="background-color: tomato">
			   <div>
				    <a href="https://www.ait.ie" class="navbar-brand"> Gym App
				     </a>
			   </div>
		   </nav>
	</header>
    <body>

        <div class="container col-md-8 col-md-offset-3" style="overflow: auto">
            <h1>Login Form</h1>
            <form action="login" method="post">

                <div class="form-group">
                    <label for="uname">User Name:</label> <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
                </div>

                <div class="form-group">
                    <label for="uname">Password:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
                </div>
                
                
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <jsp:include page="../common/footer.jsp"></jsp:include>
    </body>

    </html>