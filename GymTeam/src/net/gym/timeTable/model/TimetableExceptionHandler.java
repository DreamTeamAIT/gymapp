package net.gym.timeTable.model;

public class TimetableExceptionHandler extends Exception {

	String message;

	public TimetableExceptionHandler(String reply) {
		message = reply;
	}

	public String getMessage() {
		return message;
	}
}
