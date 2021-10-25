package net.gym.instructor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.gym.instructor.model.Instructor;

public class InstructorDao {
	public boolean validate(Instructor instructor) throws ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

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

	public List<Instructor> queryInstructor() throws ClassNotFoundException {
		List<Instructor> instructorList = new ArrayList();

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM gym.instructor;")) {

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Instructor instructor = new Instructor();
				instructor.setId(id);
				instructor.setGender(gender);
				instructor.setName(name);
				instructorList.add(instructor);

			}

		} catch (SQLException e) {
			// process sql exception
//            printSQLException(e);
			System.out.println();
		} finally {

		}
		return instructorList;

	}

}
