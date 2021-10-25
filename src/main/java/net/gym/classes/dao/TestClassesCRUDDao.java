package net.gym.classes.dao;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import net.gym.classes.model.Classes;

@RunWith(MockitoJUnitRunner.class)
class TestClassesCRUDDao {

	@Mock
	private ClassesCRUDDao mockDao;

	@Rule // initMocks
	public MockitoRule rule = MockitoJUnit.rule();

	@Test
	void InsertClassesTest() throws SQLException {
		ClassesCRUDDao mockDao = mock(ClassesCRUDDao.class);

		Classes classes = new Classes("classname", "instructor", "classtime");

		mockDao.insertClasses(classes);

		verify(mockDao).insertClasses(classes);

	}

	@Test
	void SelectClassesTest() throws SQLException {

		ClassesCRUDDao mockDao = mock(ClassesCRUDDao.class);

		Classes classes = new Classes(1, "classname", "instructor", "classtime");

		mockDao.insertClasses(classes);

		when(mockDao.selectClasses(1)).thenReturn(classes);

	}

	@Test
	void SelectAllClassesTest() throws SQLException {

		ClassesCRUDDao mockDao = mock(ClassesCRUDDao.class);

		Classes classes = new Classes(1, "classname", "instructor", "classtime");

		List<Classes> list = new ArrayList<>();

		list.add(classes);
		// mockDao.insertClasses(classes);

		when(mockDao.selectAllClasses()).thenReturn(list);

	}

	@Test
	void deleteClassesTest() throws SQLException {

		ClassesCRUDDao mockDao = mock(ClassesCRUDDao.class);

		Classes classes = new Classes(1, "classname", "instructor", "classtime");

		mockDao.insertClasses(classes);

		when(mockDao.deleteClasses(1)).thenReturn(true);

	}

	@Test
	void updateClassesTest() throws SQLException {

		ClassesCRUDDao mockDao = mock(ClassesCRUDDao.class);

		Classes classes = new Classes(1, "classname", "instructor", "classtime");

		mockDao.insertClasses(classes);

		when(mockDao.updateClasses(classes)).thenReturn(true);

	}

}
