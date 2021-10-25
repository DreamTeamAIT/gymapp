package net.gym.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gym.registration.dao.CustomerDao;
import net.gym.registration.model.Customer;

/**
 * Servlet implementation class customerServlet
 */
@WebServlet("/customerlogIn")
public class CustomerLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerDao customerDao = new CustomerDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerLogInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customerLogIn.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		try {
			// We want to check for password and email duplicates, and if there are we want
			// to stop the page and display an error
			// If it passes, we want to register the customer.
			Customer customer = new Customer("", "", password, email);
			boolean check = customerDao.logInChecker(customer);
			System.out.println(check);
			if (check) {
				customerDao.registerCustomer(customer);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customerDetails.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customerLogIn.jsp");
				dispatcher.forward(request, response);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
