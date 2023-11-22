package hw6_21000709_hoangtuantu.excercise05;

import hw6_21000709_hoangtuantu.excercise01.PriorityQueue;
import hw6_21000709_hoangtuantu.excercise01.SortedLinkedPriorityQueue;

import java.util.Random;

public class AirportSystem {
	PriorityQueue<Time, Event> queue = new SortedLinkedPriorityQueue<>();
	public void insert(Event event, Time time){
		queue.insert(time, event);
	}

	public Event removeMin(){
		return queue.removeMin().getValue();
	}

	@Override
	public String toString() {
		return queue.toString();
	}

	public static void main(String[] args) {
		AirportSystem system = new AirportSystem();
		Random random = new Random();
		for (int i = 0; i < 100; i++){
			if (random.nextBoolean()){
				system.insert(new Landing(), new Time());
			}else{
				system.insert(new Takeoff(), new Time());
			}
		}

		System.out.println(system);
	}
}
