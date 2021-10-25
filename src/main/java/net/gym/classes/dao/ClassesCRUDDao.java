package net.gym.classes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.gym.classes.model.Classes;

public class ClassesCRUDDao implements IClassesCRUDDao {

	private static final String INSERT_CLASSES_SQL = "INSERT INTO classes"
			+ "  (classname, instructor, classtime) VALUES " + " ( ?, ?, ?);";

	private static final String SELECT_CLASSES_BY_ID = "select classID,classname,instructor,classtime from classes where classID =?";
	private static final String SELECT_ALL_CLASSES = "select * from classes";
	private static final String DELETE_CLASSES_BY_ID = "delete from classes where classID = ?;";
	private static final String UPDATE_CLASSES = "update classes set classname = ?, instructor= ?, classtime =? where classID = ?;";

	public ClassesCRUDDao() {
	}

	@Override
	public void insertClasses(Classes classes) throws SQLException {
		System.out.println(INSERT_CLASSES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLASSES_SQL)) {
			preparedStatement.setString(1, classes.getClassname());
			preparedStatement.setString(2, classes.getInstructor());
			preparedStatement.setString(3, classes.getClasstime());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}

	@Override
	public Classes selectClasses(int classID) {
		Classes classes = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASSES_BY_ID);) {
			preparedStatement.setInt(1, classID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("classID");
				String classname = rs.getString("classname");
				String instructor = rs.getString("instructor");
				String classtime = rs.getString("classtime");

				classes = new Classes(id, classname, instructor, classtime);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return classes;
	}

	@Override
	public List<Classes> selectAllClasses() {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Classes> classes = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASSES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("classID");
				String classname = rs.getString("classname");
				String instructor = rs.getString("instructor");
				String classtime = rs.getString("classtime");

				classes.add(new Classes(id, classname, instructor, classtime));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return classes;
	}

	@Override
	public boolean deleteClasses(int classID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CLASSES_BY_ID);) {
			statement.setInt(1, classID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	@Override
	public boolean updateClasses(Classes classes) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CLASSES);) {
			statement.setString(1, classes.getClassname());
			statement.setString(2, classes.getInstructor());
			statement.setString(3, classes.getClasstime());
			statement.setInt(4, classes.getClassID());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
