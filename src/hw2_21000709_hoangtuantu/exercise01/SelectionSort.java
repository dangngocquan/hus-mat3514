package hw2_21000709_hoangtuantu.exercise01;

import java.util.Arrays;

public class SelectionSort implements Sort {
    private int minIndex(int[] numbers,int start){
        int index = start;
        for (int i = start + 1; i < numbers.length; i++){
            if (numbers[index] > numbers[i]){
                index = i;
            }
        }
        return index;
    }

    private int maxIndex(int[] numbers, int start){
        int index = start;
        for (int i = start + 1; i < numbers.length; i++){
            if (numbers[index] < numbers[i]){
                index = i;
            }
        }
        return index;
    }

    public void sort(int[] numbers){
        sort(numbers, true, false);
    }

    @Override
    public void sort(int[] numbers, boolean ascending) {
        sort(numbers, ascending, false);
    }

    public void sort(int[] numbers, boolean ascending, boolean stepByStep){
        int comparisons = 0, swap = 0, step = 1;
        for (int i = 0; i < numbers.length - 1; i++) {
            int index = ascending ? minIndex(numbers, i) : maxIndex(numbers, i);
            comparisons += numbers.length - i - 1;

            if (i != index){
                int number = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = number;
                swap++;
            }
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
