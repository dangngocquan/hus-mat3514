package hw2_21000709_hoangtuantu.exercise06;

import hw2_21000709_hoangtuantu.exercise01.QuickSort;
import hw2_21000709_hoangtuantu.exercise01.SortSolution;
import hw2_21000709_hoangtuantu.exercise01.Statistics;

import java.util.Arrays;
import java.util.Random;

public class KthLargestNumber {

    public static int solution(int[] numbers, int index){
        SortSolution solution = new SortSolution();
        solution.setNewSort(new QuickSort(), numbers);
        solution.sort(false);
        return numbers[index - 1];
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt((int) Math.pow(10, 4)) + 1;
        int[] numbers = Statistics.initializeArray(size);
        int index = random.nextInt(size) + 1;
        System.out.println("Input array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Index: " + index);
        System.out.println("The "+ index + "th largest element in the array is: " + solution(numbers, index - 1));
    }
}
