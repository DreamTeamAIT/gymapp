
// GIT web_link:		https://github.com/DreamTeamAIT/gymapp/tree/agron

package net.gym.timeTable.dao;

import java.sql.SQLException;
import java.util.List;

import net.gym.timeTable.model.TimeTable;



public interface ITimetableDAO {

 void insertTimetable(TimeTable timetable) throws SQLException;

 TimeTable selectTimetable(int id);

 List<TimeTable> selectAllTimetable();

 boolean deleteTimetable(int id) throws SQLException;

 boolean updateTimetable(TimeTable timetable) throws SQLException;

}