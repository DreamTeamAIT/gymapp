package net.gym.classes.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gym.classes.dao.ClassesCRUDDao;
import net.gym.classes.model.Classes;

/**
 * Servlet implementation class ClassesCRUDServlet
 */
@WebServlet("/")
public class ClassesCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassesCRUDDao classesCRUDDao;

	public void init() {
		classesCRUDDao = new ClassesCRUDDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassesCRUDServlet() {
		super();
		// TODO Auto-generated constructor stub
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
				insertClasses(request, response);
				break;
			case "/delete":
				deleteClasses(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateClasses(request, response);
				break;
			case "/list":
				listClasses(request, response);
				break;

			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listClasses(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Classes> listClasses = classesCRUDDao.selectAllClasses();
		request.setAttribute("listClasses", listClasses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("classes/classes-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("classes/classes-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int classID = Integer.parseInt(request.getParameter("classID"));
		Classes existingClass = classesCRUDDao.selectClasses(classID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("classes/classes-form.jsp");
		request.setAttribute("classes", existingClass);
		dispatcher.forward(request, response);

	}

	private void insertClasses(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String classname = request.getParameter("classname");
		String instructor = request.getParameter("instructor");
		String classtime = request.getParameter("classtime");

		/*
		 * DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd"); LocalDate
		 * targetDate = LocalDate.parse(request.getParameter("targetDate"),df);
		 */

		Classes newClasses = new Classes(classname, instructor, classtime);
		classesCRUDDao.insertClasses(newClasses);
		response.sendRedirect("list");
	}

	private void updateClasses(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int classID = Integer.parseInt(request.getParameter("classID"));

		String classname = request.getParameter("classname");
		String instructor = request.getParameter("instructor");
		String classtime = request.getParameter("classtime");

		Classes updateClasses = new Classes(classID, classname, instructor, classtime);

		classesCRUDDao.updateClasses(updateClasses);

		response.sendRedirect("list");
	}

	private void deleteClasses(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int classID = Integer.parseInt(request.getParameter("classID"));
		classesCRUDDao.deleteClasses(classID);
		response.sendRedirect("list");
	}

}
