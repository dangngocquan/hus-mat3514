package hw2_21000709_hoangtuantu.exercise01;


import java.util.Arrays;

public class BubbleSort implements Sort{
    @Override
    public void sort(int[] numbers, boolean ascending) {
        sort(numbers, ascending, false);
    }

    @Override
    public void sort(int[] numbers){
        sort(numbers, true, false);
    }

    @Override
    public void sort(int[] numbers, boolean ascending, boolean stepByStep) {
        int comparisons = 0, swap = 0, step = 1;
        for (int i = 0; i < numbers.length - 1; i++){
            boolean swapped = false;
            for (int j = 0; j < numbers.length - i - 1; j++){
                comparisons++;
                if (ascending ? numbers[j] > numbers[j + 1] : numbers[j] < numbers[j + 1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                    swap++;
                }

                if (stepByStep){
                    System.out.println("Array at step " + step + " : ");
                    System.out.println(Arrays.toString(numbers));
                    step++;
                }
            }
            if (!swapped){
                break;
            }
        }
        if (stepByStep){
            System.out.println("Number of comparisons: " + comparisons);
            System.out.println("Number of swap: " + swap);
        }
    }
}
