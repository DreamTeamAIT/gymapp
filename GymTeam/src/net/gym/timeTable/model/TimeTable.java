package net.gym.timeTable.model;

//import net.gym.timeTable.test.TimetableExceptionHandler;

public class TimeTable {

	private int id;
	private String time;
	private String myClass;
	private String instructor;
	
	public int getId() {
		return id;
		
		
	}
	
	public TimeTable() {
		super();
	}

	public TimeTable(int id, String time, String myClass, String instructor) {
		super();
		this.id = id;
		this.time = time;
		this.myClass = myClass;
		this.instructor = instructor;
			
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMyClass() {
		return myClass;
	}
	public void setMyClass(String myClass) {
		this.myClass = myClass;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	

	public void validateId_timetable(int minValue) {
		// TODO Auto-generated method stub
		
	}

	// +++++++++++++++++++++++++++++ validate Id
	//Id is a positive number
	// we throw an exception for negative numbers

	//public void validateId(int id) throws TimetableExceptionHandler {
		//if (id < 0)
			//throw new TimetableExceptionHandler("Error: You cant enter a number below 1");
	//}
	
	
}
