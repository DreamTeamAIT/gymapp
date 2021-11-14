package net.gym.timeTable.model;

import junit.framework.TestCase;
import net.gym.timeTable.model.TimeTable;

public class TimeTableTest extends TestCase {
	
	

	// +++++++++++++++++++++++++++ TEST Id +++++++++++++++++++++++++++++++++

// Test #: 1	min value
	// Test Objective:To catch an invalid -  Id number
	// Inputs: id = Integer.MIN_VALUE
	// Expected Output: Error: You can't enter a number below 1"

	public void testValidateId() {
		try {
			TimeTable TTObj = new TimeTable();
			TTObj.validateId(Integer.MIN_VALUE);
			fail("Exception expected");
		} catch (TimetableExceptionHandler e) {
			assertEquals("Error: You can't enter a number below 1", e.getMessage());
		}
	}

	
// +++++++++++++++++++++++++++ TEST myClass +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Test 2:  empty  myClass
		// Test Objective:To catch an empty - myClass
	
		// Inputs: name = ""
		// Expected Output: Error: Your myClass must contain characters"
		public void testValidateMyClass1() {
			try {
				TimeTable driverObj = new TimeTable();
				driverObj.ValidateMyClass("");
				fail("Exception expected");
			} catch (TimetableExceptionHandler e) {
				assertEquals("Error: myClass must contain characters", e.getMessage());
			}
		}
	
	// ******************************************
		// Test #: myClass length greater than 30
		// Test Objective:To catch myClass length greater than 30
		// Inputs:myClass = "myClass type length is greater than30 so there must be an exception"
		// Expected Output: Error: myClass length must be less than 30"
		public void testValidateMyClass2() {
			try {
				TimeTable driverObj = new TimeTable();
				driverObj.ValidateMyClass("hello my length is greater than 45 so there must be an exception");
				fail("Exception expected");
			} catch (TimetableExceptionHandler e) {
				assertEquals("Error: myClass length not greater then 30", e.getMessage());
			}
		}
		
		
//*************************** TEST instructor  ************************************************************************
		
		// Test 2:  empty instructor
				// Test Objective:To catch an empty - instructor
			
				// Inputs: name = ""
				// Expected Output: Error: Your instructor must contain characters"
				public void testValidateInstructor1() {
					try {
						TimeTable TTObj = new TimeTable();
						TTObj.ValidateInstructor("");
						fail("Exception expected");
					} catch (TimetableExceptionHandler e) {
						assertEquals("Error: instructor must contain characters", e.getMessage());
					}
				}
			
			// ******************************************
				// Test #: instructor length greater than 30
				// Test Objective:To catch instructor length greater than 30
				// Inputs:instructor = "instructor type length is greater than30 so there must be an exception"
				// Expected Output: Error: instructor length must be less than 30"
				public void testValidateinstructor2() {
					try {
						TimeTable TTObj = new TimeTable();
						TTObj.ValidateInstructor("Agronnn nnnnnnnnnnnnnnnnnnn nnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
						fail("Exception expected");
					} catch (TimetableExceptionHandler e) {
						assertEquals("Error: instructor name's length not greater than 30", e.getMessage());
					}
				}
				
		
}

