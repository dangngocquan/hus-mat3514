package hw2_21000709_hoangtuantu.exercise04;

import hw2_21000709_hoangtuantu.exercise01.QuickSort;
import hw2_21000709_hoangtuantu.exercise01.SortSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Frequency {
    public static Map<Integer, Integer> solve(int[] numbers){
        Map<Integer, Integer> result = new HashMap<>();
        for (int number : numbers) {
            if (result.containsKey(number)){
                result.put(number, result.get(number) + 1);
            } else {
                result.put(number, 1);
            }
        }
        return result;
    }

    public static void printResult(Map<Integer, Integer> result){
        int[] keys = new int[result.keySet().size()];
        int index = 0;
        for (int key: result.keySet()){
            keys[index] = key;
            index++;
        }
        SortSolution sort = new SortSolution();
        sort.setNewSort(new QuickSort(), keys);
        for (Integer key: keys){
            System.out.print(key + " " + result.get(key) + "; ");
        }
    }

    static Random random = new Random();

    public static int[] initializeArray(int size){
        int[]  numbers = new int[size];
        for (int i = 0; i < size; i++){
            numbers[i] = random.nextInt((int) Math.pow(10, 3));
        }
        return numbers;
    }

    public static void main(String[] args) {
        int size = random.nextInt(10000) + 1; // initialize size of array
        int[] numbers = initializeArray(size); // initialize array
        System.out.println("Input Array: ");
        System.out.println(Arrays.toString(numbers)); // print out input array

        System.out.println("Answer is: ");
        printResult(solve(numbers));
    }
}
