package hw6_21000709_hoangtuantu.excercise04;

import hw6_21000709_hoangtuantu.excercise01.*;

import java.util.ArrayList;
import java.util.Random;

public class InsertTime {
	static Random random = new Random();
	public static Double insertTime(PriorityQueue<Integer, Integer> queue, int size){
		System.out.println("Getting data for size " + size);
		double time = 0.0;
		for (int i = 0; i < size; i++){
			int data = random.nextInt();
			long start = System.nanoTime();
			queue.insert(data, data);
			long end = System.nanoTime();
			time += end - start;
		}
		return time;
	}

	public static ArrayList<Double> insertTimeData(PriorityQueue<Integer, Integer> queue){
		int[] sizes = new int[6];
		for (int i = 0; i < 6; i++){
			sizes[i] = (int) Math.pow(10, 3 + i);
		}
		ArrayList<Double> data = new ArrayList<>();
		for (int size : sizes){
			data.add(insertTime(queue , size));
		}
		return data;
	}

	public static ArrayList<ArrayList<Double>> times(){
		PriorityQueue<Integer, Integer>[] queues = new PriorityQueue[]{new SortedLinkedPriorityQueue(), new SortedArrayPriorityQueue(), new UnsortedLinkedPriorityQueue(), new UnsortedArrayPriorityQueue() };
		ArrayList<ArrayList<Double>> times = new ArrayList<>();
		for (PriorityQueue<Integer, Integer> queue: queues){
			System.out.println("Getting data for " + queue.getClass().getSimpleName());
			times.add(insertTimeData(queue));
		}
		return times;
	}
}
