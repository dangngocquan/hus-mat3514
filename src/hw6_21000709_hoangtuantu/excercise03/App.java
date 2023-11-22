package hw6_21000709_hoangtuantu.excercise03;

import hw6_21000709_hoangtuantu.excercise03.service.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
	public static Integer[] initializeArray(int size, int max){
		Random    random  = new Random();
		Integer[] numbers = new Integer[size];
		for (int i = 0; i < size; i++){
			numbers[i] = random.nextInt(max);
		}
		return numbers;
	}

	public static Integer[] copyOf(Integer[] numbers){
		Integer[] result = new Integer[numbers.length];
		System.arraycopy(numbers,0,result,0,numbers.length);
		return result;
	}

	public static double runtime(Sort<Integer> sort, Integer[] numbers) {
		Integer[]             copy     = copyOf(numbers);
		SortSolution<Integer> solution = new SortSolution<>(sort, copy);
		long                  start    = System.nanoTime();
		solution.sort();
		return System.nanoTime() - start;
	}
	public static List<List<Double>> getData(){
		List<List<Double>> data = new ArrayList<>();
		Sort<Integer>[] sorts  = new Sort[]{new BubbleSort<Integer>(), new InsertionSort<Integer>(), new SelectionSort<Integer>(),
				new ShellSort<Integer>(), new QuickSort<Integer>(), new MergeSort<Integer>(), new HeapSort<Integer>()};
		for (Sort<Integer> sort: sorts){
			List<Double> runtime = new ArrayList<>();
			for (int size = 1000; size <= 1000000; size *= 2){
				Integer[] numbers = initializeArray(size,(int) Math.pow(10, 4));
				runtime.add(runtime(sort, numbers));
			}
			data.add(runtime);
		}
		return data;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			List<List<Double>> data = getData();
			new Statics("Custom Chart Example", data);
		});
	}
}
