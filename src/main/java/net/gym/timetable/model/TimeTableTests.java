package net.gym.timetable.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TimeTableTests {

	TimeTable timetable;

	@Test
	void TimeTableConstructortest() {
		String classname = "pilates";
		String instructor = "Paul";
		String time = "15:00";
		timetable = new TimeTable(time, classname, instructor);
		assertEquals(timetable.getMyClass(), "pilates");
		assertEquals(timetable.getInstructor(), "Paul");
		assertEquals(timetable.getTime(), "15:00");
	}
	
	
	@Test
	void TimeTableConstructorOverLoadtest() {
		String classname = "pilates";
		String instructor = "Paul";
		String time = "15:00";
		int id = 1234;
		timetable = new TimeTable(id,time, classname, instructor);
		assertEquals(timetable.getMyClass(), classname);
		assertEquals(timetable.getInstructor(), instructor);
		assertEquals(timetable.getTime(), time);
		assertEquals(timetable.getId(),id);
	} 
	
	
	
	@Test
	void TimeTableSetterstest() {
		String classname = "pilates";
		String instructor = "Paul";
		String classtime = "15:00";
		int id = 12345;
		timetable = new TimeTable(id,classtime, classname, instructor);
		assertEquals(timetable.getMyClass(), classname);
		assertEquals(timetable.getInstructor(), instructor);
		assertEquals(timetable.getTime(), classtime);
		assertEquals(timetable.getId(),id);
		timetable.setId(54321);
		timetable.setMyClass("soccer");
		timetable.setTime("10:00");
		timetable.setInstructor("Ronaldo");
		assertEquals(timetable.getId(), 54321);
		assertEquals(timetable.getMyClass(), "soccer");
		assertEquals(timetable.getInstructor(), "Ronaldo");
		assertEquals(timetable.getTime(), "10:00");
	}
	
}
