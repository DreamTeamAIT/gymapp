package net.gym.timeTable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import  net.gym.timeTable.utils.JDBCUtils;
import net.gym.timeTable.model.TimeTable;

public class TimetableDAO implements ITimetableDAO {

	private static final String INSERT_TIMETABLE_SQL = "INSERT INTO timetable "
			+ "  (myTime, myClass, instructor) VALUES " + " ( ?, ?, ?);";

	private static final String SELECT_TIMETABLE_BY_ID = "select id,myTime,myClass,instructor from timetable where id =?";
	private static final String SELECT_ALL_TIMETABLE = "select * from timetable";
	private static final String DELETE_TIMETABLE_BY_ID = "delete from timetable where id = ?;";
	private static final String UPDATE_TIMETABLE = "update timetable set myTime = ?, myClass= ?, instructor =? where id = ?;";

	public TimetableDAO() {
	}

	@Override
	public void insertTimetable(TimeTable timetable) throws SQLException {
		System.out.println(INSERT_TIMETABLE_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TIMETABLE_SQL)) {
			preparedStatement.setString(1, timetable.getTime());
			preparedStatement.setString(2, timetable.getMyClass());
			preparedStatement.setString(3, timetable.getInstructor());
			/*
			 * preparedStatement.setDate(4,
			 * JDBCUtils.getSQLDate(timetable.getTargetDate()));
			 * preparedStatement.setBoolean(5, timetable.getStatus());
			 */
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}

	@Override
	public TimeTable selectTimetable(int id) {
		TimeTable timetable = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TIMETABLE_BY_ID);) {
			preparedStatement.setLong(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id1 = rs.getInt("id");
				String myTime = rs.getString("myTime");
				String myClass = rs.getString("myClass");
				String instructor = rs.getString("instructor");
				/*
				 * LocalDate targetDate = rs.getDate("target_date").toLocalDate(); boolean
				 * isDone = rs.getBoolean("is_done");
				 */
				timetable = new TimeTable(id1, myTime, myClass, instructor);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return timetable;
	}

	@Override
	public List<TimeTable> selectAllTimetable() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<TimeTable> timetables = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TIMETABLE);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String myTime = rs.getString("myTime");
				String myClass = rs.getString("myClass");
				String instructor = rs.getString("instructor");
				/*
				 * LocalDate targetDate = rs.getDate("target_date").toLocalDate(); boolean
				 * isDone = rs.getBoolean("is_done");
				 */
				timetables.add(new TimeTable(id, myTime, myClass, instructor));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return timetables;
	}

	@Override
	public boolean deleteTimetable(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TIMETABLE_BY_ID);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	
// update timetable
	@Override
	public boolean updateTimetable(TimeTable timetable) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TIMETABLE);) {
			
			statement.setString(1, timetable.getTime());
			statement.setString(2, timetable.getMyClass());
			statement.setString(3, timetable.getInstructor());
			
			statement.setLong(4, timetable.getId());
			
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}