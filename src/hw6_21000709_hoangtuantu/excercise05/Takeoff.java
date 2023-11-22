package hw6_21000709_hoangtuantu.excercise05;

public class Takeoff extends Event {

	@Override
	public void info() {
		System.out.println("Take off event! - id: " + id);
	}

	@Override
	public String toString(){
		return "Taking off!";
	}
}
