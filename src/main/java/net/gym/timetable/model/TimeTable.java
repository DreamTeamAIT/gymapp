package net.gym.timetable.model;

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
		this.id = id;
		this.time = time;
		this.myClass = myClass;
		this.instructor = instructor;
	}
	
	public TimeTable(String time, String myClass, String instructor) {
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

}
