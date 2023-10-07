package hw2_21000709_hoangtuantu.exercise01;

import java.util.Arrays;

public class ShellSort implements Sort{
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
        for (int gap = numbers.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < numbers.length; i++) {
                int temp = numbers[i];
                int j;

                for (j = i; j >= gap && (ascending ? numbers[j - gap] > temp : numbers[j - gap] < temp); j -= gap) {
                    numbers[j] = numbers[j - gap];
                    comparisons++;
                }

                if (j != i){
                    swap++;
                    numbers[j] = temp;
                }

                if (stepByStep){
                    System.out.println("Array at step " + step + " : ");
                    System.out.println(Arrays.toString(numbers));
                    step++;
                }
            }
        }

        if (stepByStep){
            System.out.println("Number of comparisons: " + comparisons);
            System.out.println("Number of swap: " + swap);
        }

    }
}
