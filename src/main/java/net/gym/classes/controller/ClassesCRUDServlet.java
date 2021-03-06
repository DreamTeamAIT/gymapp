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
import javax.servlet.http.HttpSession;

import net.gym.classes.dao.ClassesCRUDDao;
import net.gym.classes.model.Classes;
import net.gym.customer.dao.CustomerDao;
import net.gym.customer.model.Customer;
import net.gym.instructor.dao.InstructorDao;
import net.gym.instructor.model.Instructor;
import net.gym.login.dao.LoginDao;
import net.gym.login.model.LoginBean;
import net.gym.timetable.dao.TimetableDAO;
import net.gym.timetable.model.TimeTable;

/**
 * Servlet implementation class ClassesCRUDServlet
 */
@WebServlet("/")
public class ClassesCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassesCRUDDao classesCRUDDao = new ClassesCRUDDao();
	private InstructorDao instructorDao = new InstructorDao();
	private TimetableDAO timetableDAO = new TimetableDAO();
	private CustomerDao customerDao = new CustomerDao();
	private LoginDao loginDao = new LoginDao();

	private String idString;
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
			case "/login":
				System.out.println("chamei login");
				authenticate(request, response);
				break;
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
			case "/insertTimetable":
				insertTimetable(request, response);
				break;
			case "/newTimetable":
				showNewTimetableForm(request, response);
				break;
			case "/deleteTimetable":
				deleteTimetable(request, response);
				break;
			case "/editTimetable":
				showEditTimetableForm(request, response);
				break;
			case "/updateTimetable":
				updateTimetable(request, response);
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
			case "/deleteInstructor":
				deleteInstructor(request, response);
				break;
			case "/timetableList":
				listTimetable(request, response);
				System.out.println("chamei timetableList");
				break;
			case "/newCustomer":
				showNewCustomerForm(request, response);
				break;
			case "/insertCustomer":
				insertCustomer(request, response);
				break;
			case "/listCustomer":
				listCustomer(request, response);
				break;
			case "/editCustomer":
				showEditCustomerForm(request, response);
				break;
			case "/updateCustomer":
				updateCustomer(request, response);
				break;
			case "/deleteCustomer":
				deleteCustomer(request, response);
				break;

			default:
				System.out.println("chamei login");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		try {
			if (loginDao.validate(loginBean)) {
				System.out.println("chamei login dao");
				List<Classes> listClasses = classesCRUDDao.selectAllClasses();
				request.setAttribute("listClasses", listClasses);
				RequestDispatcher dispatcher = request.getRequestDispatcher("classes/classes-list.jsp");
				dispatcher.forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void listTimetable(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<TimeTable> listTimetable = timetableDAO.selectAllTimetable();
		request.setAttribute("listTimetable", listTimetable);
		RequestDispatcher dispatcher = request.getRequestDispatcher("timetable/timetable-list.jsp");
		dispatcher.forward(request, response);
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

	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Customer> customerList = customerDao.selectAllCustomer();
		request.setAttribute("listCustomer", customerList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customerList.jsp");
		dispatcher.forward(request, response);

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("classes/classes-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewTimetableForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("timetable/timetable-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewInstructorForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("instructor/instructor.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewCustomerForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customerRegister.jsp");
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

	private void showEditTimetableForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		TimeTable existingTimetable = timetableDAO.selectTimetable(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("timetable/timetable-form.jsp");
		request.setAttribute("timetable", existingTimetable);
		dispatcher.forward(request, response);

	}

	private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		idString = request.getParameter("id");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customerUpdate.jsp");
		dispatcher.forward(request, response);
	}

	private void insertTimetable(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		// int id = Integer.parseInt(request.getParameter("id"));
		// Int id = request.getParameter("id");
		String time = request.getParameter("time");
		String myClass = request.getParameter("myClass");
		String instructor = request.getParameter("instructor");

		TimeTable newTimetable = new TimeTable(time, myClass, instructor);
		timetableDAO.insertTimetable(newTimetable);
		response.sendRedirect("timetableList");
	}

	private void deleteTimetable(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		timetableDAO.deleteTimetable(id);
		response.sendRedirect("timetableList");
	}

	private void updateTimetable(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String time = request.getParameter("time");
		String myClass = request.getParameter("myClass");
		String instructor = request.getParameter("instructor");

		TimeTable updateTimetable = new TimeTable(id, time, myClass, instructor);

		timetableDAO.updateTimetable(updateTimetable);

		response.sendRedirect("timetableList");
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

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		/*
		 * DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd"); LocalDate
		 * targetDate = LocalDate.parse(request.getParameter("targetDate"),df);
		 */

		Customer customer = new Customer("", firstName, lastName, password, email);
		customerDao.registerCustomer(customer);
		response.sendRedirect("listCustomer");
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

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String id = idString;
		try {
			// We want to check for password and email duplicates, and if there are we want
			// to stop the page and display an error
			// If it passes, we want to update the customer.
			Customer customer = new Customer("", firstName, lastName, password, email);

			customerDao.updateCustomer(customer, id);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listCustomer");
	}

	private void deleteClasses(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int classID = Integer.parseInt(request.getParameter("classID"));
		classesCRUDDao.deleteClasses(classID);
		response.sendRedirect("list");
	}

	private void deleteInstructor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		instructorDao.deleteInstructor(id);
		response.sendRedirect("instructorList");
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		// TODO Auto-generated method stub
		idString = request.getParameter("id");
		customerDao.deleteCustomer(idString);
		response.sendRedirect("listCustomer");
	}
}
