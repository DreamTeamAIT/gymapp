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
import net.gym.instructor.dao.InstructorDao;
import net.gym.instructor.model.Instructor;

/**
 * Servlet implementation class ClassesCRUDServlet
 */
@WebServlet("/")
public class ClassesCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassesCRUDDao classesCRUDDao = new ClassesCRUDDao();
	private InstructorDao instructorDao = new InstructorDao();

	// public void init() {
	// classesCRUDDao = new ClassesCRUDDao();
	// }

	// public void initInstructors() {
	// instructorDao = new InstructorDao();
	// }

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
			case "/instructorList":
				ListTodo(request, response);
				System.out.println("chamei instructorList");
				break;
			case "/newInstructor":
				showNewInstructorForm(request, response);
				break;
			case "/insertInstructor":
				insertInstructor(request, response);
				break;
			case "/editInstructor":
				showEditInstructorForm(request, response);
				break;
			case "/updateInstructor":
				updateInstructor(request, response);
				break;

			default:
				System.out.println("chamei login");
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
		System.out.println("chamei listCLasses");
		List<Classes> listClasses = classesCRUDDao.selectAllClasses();
		request.setAttribute("listClasses", listClasses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("classes/classes-list.jsp");
		dispatcher.forward(request, response);
	}

	private void ListTodo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("instructor/instructorlist.jsp");
		// dispatcher.forward(request, response);
		List<Instructor> listInstructors = instructorDao.selectAllInstructors();
		request.setAttribute("listInstructors", listInstructors);
		RequestDispatcher dispatcher = request.getRequestDispatcher("instructor/instructorlist.jsp");
		System.out.println("chamei ListTodo");
		dispatcher.forward(request, response);

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("classes/classes-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewInstructorForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("instructor/instructor.jsp");
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

	private void showEditInstructorForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Instructor existingInstructor = instructorDao.selectInstructor(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("instructor/instructor-form.jsp");
		request.setAttribute("instructor", existingInstructor);
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

	private void insertInstructor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");

		Instructor newInstructor = new Instructor(name, gender);
		instructorDao.insertInstructor(newInstructor);
		response.sendRedirect("instructorList");
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

	private void updateInstructor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");

		Instructor updateInstructor = new Instructor(id, name, gender);

		instructorDao.updateInstructor(updateInstructor);

		response.sendRedirect("instructorList");
	}

	private void deleteClasses(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int classID = Integer.parseInt(request.getParameter("classID"));
		classesCRUDDao.deleteClasses(classID);
		response.sendRedirect("list");
	}

}
