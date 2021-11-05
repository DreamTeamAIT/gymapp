package net.gym.timetable.dao;

import java.sql.SQLException;
import java.util.List;

import net.gym.timetable.model.TimeTable;

public interface ITimetableDAO {

	void insertTimetable(TimeTable timetable) throws SQLException;

	TimeTable selectTimetable(int id);

	List<TimeTable> selectAllTimetable();

	boolean deleteTimetable(int id) throws SQLException;

	boolean updateTimetable(TimeTable timetable) throws SQLException;

}
