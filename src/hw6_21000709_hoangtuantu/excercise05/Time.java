package hw6_21000709_hoangtuantu.excercise05;

import java.util.Random;

public class Time implements Comparable<Time> {
	int hour;
	int minute;
	int second;

	public Time() {
		Random random = new Random();
		hour = random.nextInt(24);
		minute = random.nextInt(60);
		second = random.nextInt(60);
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

	@Override
	public int compareTo(Time o) {
		if (this.hour < o.hour){
			return -1;
		} else if (this.hour > o.hour){
			return 1;
		} else if (this.minute < o.minute){
			return -1;
		} else if (this.minute > o.minute){
			return 1;
		} else if (this.second < o.second){
			return -1;
		} else if (this.second > o.second){
			return 1;
		}return 0;
	}
}