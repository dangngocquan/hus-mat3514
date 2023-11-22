package hw6_21000709_hoangtuantu.excercise04;

import hw6_21000709_hoangtuantu.excercise01.*;

import java.util.ArrayList;
import java.util.Random;

public class removeMinTime {
	static Random random = new Random();
	public static Integer[] getData(int size){
		Integer[] data = new Integer[size];
		for(int i = 0; i < size; i++){
			data[i] = random.nextInt(10);
		}
		return data;
	}

	public static Double removeTime(PriorityQueue<Integer, Integer> queue, int size){
		double time = 0.0;
		for (int i = 0; i < size; i++){
			long start = System.nanoTime();
			queue.removeMin();
			long end = System.nanoTime();
			time += end - start;
		}
		return time;
	}

	public static ArrayList<Double> remove(PriorityQueue<Integer, Integer> queue){
		int[] sizes = new int[6];
		for (int i = 0; i < 6; i++){
			sizes[i] = (int) Math.pow(10, 3 + i);
		}
		ArrayList<Double> data = new ArrayList<>();
		for (int size : sizes){
			data.add(removeTime(queue , size));
		}
		return data;
	}

	public static ArrayList<ArrayList<Double>> times(){
		PriorityQueue<Integer, Integer>[] queues = new PriorityQueue[]{new SortedLinkedPriorityQueue(), new SortedArrayPriorityQueue(), new UnsortedLinkedPriorityQueue(), new UnsortedArrayPriorityQueue() };
		ArrayList<ArrayList<Double>> times = new ArrayList<>();
		for (PriorityQueue<Integer, Integer> queue: queues){
			times.add(remove(queue));
		}
		return times;
	}
}
