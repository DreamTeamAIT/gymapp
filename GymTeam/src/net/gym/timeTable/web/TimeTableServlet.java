package net.gym.timeTable.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.gym.timeTable.dao.TimetableDAO;
import net.gym.timeTable.model.TimeTable;


/*
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the todo.
 */

@WebServlet("/")
public class TimeTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TimetableDAO timetableDAO;

    public void init() {
    	timetableDAO = new TimetableDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertTimetable(request, response);
                    break;
                case "/delete":
                    deleteTimetable(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateTimetable(request, response);
                    break;
               case "/list":
                  listTimetable(request, response);            
                   break;
               /** default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
                    dispatcher.forward(request, response);
                    break;*/
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    // read 
    private void listTimetable(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < TimeTable > listTimetable = timetableDAO.selectAllTimetable();
        request.setAttribute("listTimetable", listTimetable);
        RequestDispatcher dispatcher = request.getRequestDispatcher("timetable/timetable-list.jsp");
        dispatcher.forward(request, response);
    }

    
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("timetable/timetable-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TimeTable existingTimetable = timetableDAO.selectTimetable(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("timetable/timetable-form.jsp");
        request.setAttribute("timetable", existingTimetable);
        dispatcher.forward(request, response);

    }

    
    // add new
    private void insertTimetable(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	
    	int id = Integer.parseInt(request.getParameter("id"));
    	//Int id = request.getParameter("id");
        String time = request.getParameter("time");
        String myClass = request.getParameter("myClass");
        String instructor = request.getParameter("instructor");

        TimeTable newTimetable = new TimeTable(id, time, myClass, instructor);
        timetableDAO.insertTimetable(newTimetable);
        response.sendRedirect("list");
    }

    
    private void updateTimeTable(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String time = request.getParameter("time");
		String myClass = request.getParameter("myClass");
		String instructor = request.getParameter("instructor");

		TimeTable timeTable = new TimeTable(id,time,myClass,instructor);

		timetableDAO.updateTimetable(timeTable);

		response.sendRedirect("timetableList");
	}
    
    // update
    private void updateTimetable(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	
        int id = Integer.parseInt(request.getParameter("id"));
        String time = request.getParameter("time");
        String myClass = request.getParameter("myClass");
        String instructor = request.getParameter("instructor");
               
        TimeTable updateTimetable = new TimeTable(id,time, myClass, instructor);

        timetableDAO.updateTimetable(updateTimetable);

        response.sendRedirect("list");
    }

    // delete
    private void deleteTimetable(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        timetableDAO.deleteTimetable(id);
        response.sendRedirect("list");
    }
}