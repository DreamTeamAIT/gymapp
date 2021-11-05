package net.gym.instructor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.gym.classes.dao.JDBCUtils;
import net.gym.instructor.model.Instructor;

public class InstructorDao {
	public boolean validate(Instructor instructor) throws ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false", "root", "admin");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into instructor(name,gender) values(?,?);")) {
			preparedStatement.setString(1, instructor.getName());
			preparedStatement.setString(2, instructor.getGender());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
//            printSQLException(e);
			System.out.println();
		} finally {

		}
		return false;

	}

	public Instructor selectInstructor(int id) {
		Instructor instructor = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select id,name,gender from instructor where id =?;");) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");

				instructor = new Instructor(id, name, gender);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return instructor;
	}

	public void insertInstructor(Instructor instructor) throws SQLException {
		System.out.println("insert into instructor(name,gender) values(?,?);");
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into instructor(name,gender) values(?,?);")) {
			preparedStatement.setString(1, instructor.getName());
			preparedStatement.setString(2, instructor.getGender());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}

	public boolean deleteInstructor(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false", "root", "admin");
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from gym.instructor where id = ?;")) {
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.execute();
		}
		return rowDeleted;
	}

	/*
	 * public boolean updateInstructor(Instructor instructor) throws SQLException {
	 * boolean rowUpdated; try (Connection connection = DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false",
	 * "root", "admin"); PreparedStatement preparedStatement = connection
	 * .prepareStatement("update gym.instructor set name = ?, gender= ? where id = ?;"
	 * )) { preparedStatement.setInt(3, instructor.getId());
	 * preparedStatement.setString(2, instructor.getGender());
	 * preparedStatement.setString(1, instructor.getName()); rowUpdated =
	 * preparedStatement.execute(); } return rowUpdated; }
	 */

	public boolean updateInstructor(Instructor instructor) throws SQLException {
		boolean rowUpdated;

		int id = instructor.getId();
		deleteInstructor(id);
		insertInstructor(instructor);
		rowUpdated = true;

		/*
		 * try (Connection connection = JDBCUtils.getConnection(); PreparedStatement
		 * preparedStatement = connection
		 * .prepareStatement("update gym.instructor set name = ?, gender= ? where id = ?;"
		 * );) { preparedStatement.setString(2, instructor.getGender());
		 * preparedStatement.setString(1, instructor.getName());
		 * preparedStatement.setInt(3, instructor.getId()); rowUpdated =
		 * preparedStatement.executeUpdate() > 0; }
		 */
		return rowUpdated;
	}

	public List<Instructor> selectAllInstructors() {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Instructor> instructors = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM gym.instructor;");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Instructor instructor = new Instructor(name, gender);
				instructor.setId(id);
				instructor.setGender(gender);
				instructor.setName(name);
				instructors.add(instructor);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return instructors;
	}

	/**
	 * public List<Instructor> queryInstructor() throws ClassNotFoundException {
	 * List<Instructor> instructorList = new ArrayList();
	 * 
	 * Class.forName("com.mysql.jdbc.Driver");
	 * 
	 * try (Connection connection = DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false",
	 * "root", "admin");
	 * 
	 * // Step 2:Create a statement using connection object PreparedStatement
	 * preparedStatement = connection.prepareStatement("SELECT * FROM
	 * gym.instructor;")) {
	 * 
	 * System.out.println(preparedStatement); ResultSet rs =
	 * preparedStatement.executeQuery();
	 * 
	 * while (rs.next()) { int id = Integer.parseInt(rs.getString("id")); String
	 * name = rs.getString("name"); String gender = rs.getString("gender");
	 * Instructor instructor = new Instructor(); instructor.setId(id);
	 * instructor.setGender(gender); instructor.setName(name);
	 * instructorList.add(instructor);
	 * 
	 * }
	 * 
	 * } catch (SQLException e) { // process sql exception // printSQLException(e);
	 * System.out.println(); } finally {
	 * 
	 * } return instructorList;
	 * 
	 * }
	 */

	public Instructor queryInstructor(int id) throws ClassNotFoundException {
		Instructor instructor = new Instructor();
		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM gym.instructor where id=?;")) {

			System.out.println(preparedStatement);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				instructor.setId(id);
				instructor.setName(name);
				instructor.setGender(gender);
			}

		} catch (SQLException e) {
			// process sql exception
//            printSQLException(e);
			System.out.println();
		} finally {

		}
		return instructor;

	}

}
