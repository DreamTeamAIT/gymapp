package net.gym.classes.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ClassesTests {

	Classes classes;

	@Test
	void ClassesConstructortest() {
		String classname = "pilates";
		String instructor = "Paul";
		String classtime = "15:00";
		int id = 12345;
		classes = new Classes(classname, instructor, classtime);
		assertEquals(classes.getClassname(), "pilates");
		assertEquals(classes.getInstructor(), "Paul");
		assertEquals(classes.getClasstime(), "15:00");
		classes = new Classes(id, classname, instructor, classtime);
	}

	@Test
	void ClassesConstructor2test() {
		String classname = "pilates";
		String instructor = "Paul";
		String classtime = "15:00";
		int id = 12345;
		classes = new Classes(id, classname, instructor, classtime);
		assertEquals(classes.getClassID(), 12345);
		assertEquals(classes.getClassname(), "pilates");
		assertEquals(classes.getInstructor(), "Paul");
		assertEquals(classes.getClasstime(), "15:00");
	}

	@Test
	void ClassesSetterstest() {
		String classname = "pilates";
		String instructor = "Paul";
		String classtime = "15:00";
		int id = 12345;
		classes = new Classes(id, classname, instructor, classtime);
		assertEquals(classes.getClassID(), 12345);
		assertEquals(classes.getClassname(), "pilates");
		assertEquals(classes.getInstructor(), "Paul");
		assertEquals(classes.getClasstime(), "15:00");
		classes.setClassID(54321);
		classes.setClassname("soccer");
		classes.setClasstime("10:00");
		classes.setInstructor("Ronaldo");
		assertEquals(classes.getClassID(), 54321);
		assertEquals(classes.getClassname(), "soccer");
		assertEquals(classes.getInstructor(), "Ronaldo");
		assertEquals(classes.getClasstime(), "10:00");

	}

}
