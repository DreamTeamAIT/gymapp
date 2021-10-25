package net.gym.classes.model;

import java.io.Serializable;

public class Classes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int classID;
	private String classname;
	private String instructor;
	private String classtime;

	public Classes(int classID, String classname, String instructor, String classtime) {
		this.classID = classID;
		this.classname = classname;
		this.instructor = instructor;
		this.classtime = classtime;
	}

	public Classes(String classname, String instructor, String classtime) {

		this.classname = classname;
		this.instructor = instructor;
		this.classtime = classtime;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getClasstime() {
		return classtime;
	}

	public void setClasstime(String classtime) {
		this.classtime = classtime;
	}

}
