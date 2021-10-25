package net.gym.classes.dao;

import java.sql.SQLException;
import java.util.List;

import net.gym.classes.model.Classes;

public interface IClassesCRUDDao {

	void insertClasses(Classes classes) throws SQLException;

	Classes selectClasses(int classID);

	List<Classes> selectAllClasses();

	boolean deleteClasses(int classID) throws SQLException;

	boolean updateClasses(Classes classes) throws SQLException;
}
