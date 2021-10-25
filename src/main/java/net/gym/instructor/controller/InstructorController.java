package net.gym.instructor.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gym.instructor.dao.InstructorDao;
import net.gym.instructor.model.Instructor;

/**
 * Servlet implementation class InstructorController
 */
@WebServlet("/instructorcontroller")
public class InstructorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InstructorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private InstructorDao instructorDao;

	public void init() {
		instructorDao = new InstructorDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher dispatcher = request.getRequestDispatcher("instructor/instructor.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		Instructor instructor = new Instructor();
		instructor.setName(name);
		instructor.setGender(gender);

		try {
			if (instructorDao.validate(instructor)) {
				// HttpSession session = request.getSession();
				// session.setAttribute("username",username);
				response.sendRedirect("loginsuccess.jsp");
			} else {
				HttpSession session = request.getSession();
				// session.setAttribute("user", username);
				// response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
