package net.gym.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.gym.registration.model.Customer;;

public class CustomerDao {
	// We want to make sure we don't have duplicate emails or passwords. This code
	// checks for that by counting how many
	// duplicates of the new email and password we get and returns an appropiate
	// error message.
	public String checkCustomer(Customer customer) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String jdbcURL = "jdbc:mysql://localhost:3306/gym?useSSL=false";
		String jdbcUsername = "root";
		String jdbcPassword = "admin";

		String DUPLICATE_EMAIL_SQL = "SELECT COUNT(*) FROM customer where email = \"" + customer.getEmail() + "\";";
		String DUPLICATE_PASSWORD_SQL = "SELECT COUNT(*) FROM customer where password = \"" + customer.getPassword()
				+ "\";";

		try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

				PreparedStatement emailPreparedStatement = connection.prepareStatement(DUPLICATE_EMAIL_SQL);
				PreparedStatement passwordPreparedStatement = connection.prepareStatement(DUPLICATE_PASSWORD_SQL)) {
			System.out.println(emailPreparedStatement);
			// Step 3: Execute the query or update query
			ResultSet result = emailPreparedStatement.executeQuery();
			result.next();
			int count = result.getInt("COUNT(*)");
			if (count > 0) {
				return "Duplicate Email";
			} else {

				System.out.println(passwordPreparedStatement);
				// Step 3: Execute the query or update query
				result = passwordPreparedStatement.executeQuery();
				result.next();
				count = result.getInt("COUNT(*)");
				if (count > 0) {
					return "Duplicate Password";
				} else {
					return "No duplicates.";
				}
			}
		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
			return "Connection Error";
		}
	}

	// This code handles entering a customer into our database.
	public int registerCustomer(Customer customer) throws ClassNotFoundException {

		String INSERT_USERS_SQL = "INSERT INTO customer" + "  (id, first_name, last_name, password, email) VALUES "
				+ " (?, ?, ?, ?, ?);";

		int result = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcURL = "jdbc:mysql://localhost:3306/gym?useSSL=false";
		String jdbcUsername = "root";
		String jdbcPassword = "admin";

		try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setString(5, customer.getEmail());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return result;

	}

	// Deletes the customer in the database
	public void deleteCustomer(Customer customer) throws ClassNotFoundException {
		String DELETE_USERS_SQL = "DELETE FROM customer WHERE first_name = \"" + customer.getFirstName()
				+ "\" AND last_name = \"" + customer.getLastName() + "\" AND password = \"" + customer.getPassword()
				+ "\" ;";

		Class.forName("com.mysql.cj.jdbc.Driver");

		String jdbcURL = "jdbc:mysql://localhost:3306/gym?useSSL=false";
		String jdbcUsername = "root";
		String jdbcPassword = "admin";

		try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
	}

	// Before deleting a customer, we check to make sure they exist.
	public boolean deleteChecker(Customer customer) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		String CHECK_DETAILS_SQL = "SELECT COUNT(*) FROM customer where first_name = \"" + customer.getFirstName()
				+ "\" AND last_name = \"" + customer.getLastName() + "\" AND password = \"" + customer.getPassword()
				+ "\" ;";

		String jdbcURL = "jdbc:mysql://localhost:3306/gym?useSSL=false";
		String jdbcUsername = "root";
		String jdbcPassword = "admin";

		try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

				PreparedStatement preparedStatement = connection.prepareStatement(CHECK_DETAILS_SQL)) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			int count = result.getInt("COUNT(*)");
			if (count == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
			return false;
		}
	}

	// When logging in, we want to check whether the username and password match an
	// existing entry. It's similar the check for existing user for registration,
	// except we're looking for entries with the same username and password.
	public boolean logInChecker(Customer customer) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String LOG_IN_SQL = "SELECT COUNT(*) FROM customer where email = \"" + customer.getEmail()
				+ "\" AND password = \"" + customer.getPassword() + "\";";

		String jdbcURL = "jdbc:mysql://localhost:3306/gym?useSSL=false";
		String jdbcUsername = "root";
		String jdbcPassword = "admin";

		try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				PreparedStatement preparedStatement = connection.prepareStatement(LOG_IN_SQL);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			int count = result.getInt("COUNT(*)");
			// It should be count == 1, since there shouldn't be duplicate entires, but
			// keeping it > 0 means if there are duplicates we can still log in.
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
			return false;
		}
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
