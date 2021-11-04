<header>
 <nav class="navbar navbar-expand-md navbar-dark"
  style="background-color: tomato">
  <div>
   
   <a href="https://www.ait.ie/" class="navbar-brand"> AIT</a>
   <li><a href="<%= request.getContextPath() %>/timetable/timeTable.jsp" class="nav-link">Timetable</a></li>
    <!--  <a href="https://www.javaguides.net" class="navbar-brand"> TimeTable</a>	-->
  </div>
  </div>

  <ul class="navbar-nav navbar-collapse justify-content-end">
   <li><a href="<%= request.getContextPath() %>/login" class="nav-link">Login</a></li>
   <li><a href="<%= request.getContextPath() %>/register" class="nav-link">Signup</a></li>
  </ul>
 </nav>
</header>
