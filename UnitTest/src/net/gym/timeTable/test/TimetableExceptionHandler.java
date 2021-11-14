package net.gym.timeTable.test;

public class TimetableExceptionHandler extends Exception {

	String message;

	public TimetableExceptionHandler(String reply) {
		message = reply;
	}

	public String getMessage() {
		return message;
	}
}
