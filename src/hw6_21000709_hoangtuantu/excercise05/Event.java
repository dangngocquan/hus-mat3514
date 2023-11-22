package hw6_21000709_hoangtuantu.excercise05;

import java.util.Random;

public abstract class Event {
	String id;

	public Event() {
		id = this.randomID();
	}

	public String getId() {
		return id;
	}

	private String randomID(){
		Random random = new Random();
		final int     SIZE = 5;
		StringBuilder id = new StringBuilder();
		for (int i = 0; i < SIZE; i++){
			id.append(random.nextInt(10));
		}
		return ("VN-" + id);
	}

	public abstract String toString();
	public abstract void info();
}
