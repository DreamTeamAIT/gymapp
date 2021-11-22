package net.gym.instructor.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

class InstructorTest {

	Instructor instructor;

	@Test
	void testInstructorStringString() {
		String name = "Shein";
		String gender = "Male";
		int id = 12345;
		instructor = new Instructor(name, gender);
		assertEquals(instructor.getName(), "Shein");
		assertEquals(instructor.getGender(), "Male");
		instructor = new Instructor(id, name, gender);
	}

	@Test
	void testInstructorIntStringString() {
		String name = "Shein";
		String gender = "Male";
		int id = 12345;
		instructor = new Instructor(id, name, gender);
		assertEquals(instructor.getId(), 12345);
		assertEquals(instructor.getName(), "Shein");
		assertEquals(instructor.getGender(), "Male");
	}

	@Test
	void instructorSetterstest() {
		String name = "Shein";
		String gender = "Male";
		int id = 12345;
		instructor = new Instructor(id, name, gender);
		assertEquals(instructor.getId(), 12345);
		assertEquals(instructor.getName(), "Shein");
		assertEquals(instructor.getGender(), "Male");
		instructor.setId(54321);
		instructor.setName("Thaigo");
		instructor.setGender("Male");
		assertEquals(instructor.getId(), 54321);
		assertEquals(instructor.getName(), "Thaigo");
		assertEquals(instructor.getGender(), "Male");
	}
}