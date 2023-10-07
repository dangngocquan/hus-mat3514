package hw2_21000709_hoangtuantu.exercise01;

import java.util.Arrays;

public class InsertionSort implements Sort{
    @Override
    public void sort(int[] numbers) {
        sort(numbers, true, false);
    }

    @Override
    public void sort(int[] numbers, boolean ascending) {
        sort(numbers, ascending, false);
    }

    @Override
    public void sort(int[] numbers, boolean ascending, boolean stepByStep) {
        int comparisons = 0, swap = 0, step = 1;
        for (int i = 1; i < numbers.length; i++){
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && (ascending ? numbers[j] > key : numbers[j] < key)){
                numbers[j + 1] = numbers[j];
                j--;
                comparisons++;
            }
            if (j + 1!= i) {
                swap++;
            }
            numbers[j + 1] = key;

            if (stepByStep){
                System.out.println("Array at step " + step + " : ");
                System.out.println(Arrays.toString(numbers));
                step++;
            }
        }

        if (stepByStep){
            System.out.println("Number of comparisons: " + comparisons);
            System.out.println("Number of swap: " + swap);
        }
    }

}
