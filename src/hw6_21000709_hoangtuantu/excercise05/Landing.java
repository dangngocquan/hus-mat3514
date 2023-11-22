package hw6_21000709_hoangtuantu.excercise05;

public class Landing extends Event {
	@Override
	public void info() {
		System.out.println("Landing Event! - id: " + id);
	}

	@Override
	public String toString(){
		return "Landing!";
	}
}
