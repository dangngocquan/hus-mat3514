package hw6_21000673_nguyenvandai.exercise3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int [] arr = generateRandomArray(100);
        measureExecutionTime("Bubble Sort",() -> Sort.BubbleSort(arr.clone()));
        measureExecutionTime("InsertionSort",() -> Sort.InsertionSort(arr.clone()));
        measureExecutionTime("mergeSort",() -> Sort.mergeSort(arr.clone(),0,arr.length - 1));
        measureExecutionTime("QuickSort",() -> Sort.QuickSort(arr.clone()));
        measureExecutionTime("SelectionSort",() -> Sort.SelectionSort(arr.clone()));
    }
    private static int [] generateRandomArray(int size){
        int [] arr = new int[size];
        Random random = new Random();
        for (int i = 0;i<size ; i++){
            arr[i] = random.nextInt();
        }
        return arr;
    }
    private static void measureExecutionTime(String algorith, Runnable runnable){
        long startTime = System.currentTimeMillis();
        runnable.run();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println(algorith + " executed in "+ executionTime+ "ms");
    }
}
