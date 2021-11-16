</header> <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
   <div>
    <a href="https://www.ait.ie" class="navbar-brand"> Gym App
     </a>
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
	
	<ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/listCustomer"
     class="nav-link">Customers</a></li>
   </ul> 
   
   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>