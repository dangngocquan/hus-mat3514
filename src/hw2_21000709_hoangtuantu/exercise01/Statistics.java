package hw2_21000709_hoangtuantu.exercise01;

import java.util.Random;

/**
 * @author Hoang Tuan Tu
 */
public class Statistics {
    /**
     * This method copy an integer array.
     *
     * @param numbers Integer array need to copy
     * @return An integer array with same element.
     */
    public static int[] copyOf(int[] numbers){
        int[] result = new int[numbers.length];
        System.arraycopy(numbers,0,result,0,numbers.length);
        return result;
    }


    /**
     * Computes the sum of an array of long integers.
     * <p>
     * This method takes an array of long integers and calculates the sum of all the elements in the array. The sum is returned as a double to ensure that the result can accommodate potentially large values.
     *
     * @param numbers An array of long integers for which the sum needs to be calculated.
     * @return The sum of the long integers as a double.
     */
    public static double sum(long[] numbers) {
        long sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return (double) sum;
    }

    /**
     * Measures the average runtime of a sorting algorithm over multiple executions.
     * <p>
     * This method measures the average runtime of a sorting algorithm when applied to an array of integers over multiple executions. The sorting algorithm is executed the specified number of times, and the average runtime in nanoseconds is calculated and returned as a double.
     *
     * @param sort An instance of a sorting algorithm that implements the Sort interface.
     * @param numbers The array of integers to be sorted in each execution.
     * @param time The number of times the sorting algorithm should be executed to calculate the average runtime.
     * @return The average runtime of the sorting algorithm in nanoseconds.
     */
    public static double runtime(Sort sort, int[] numbers, int time) {
        long[] container = new long[time];
        for (int i = 0; i < time; i++) {
            int[] copy = copyOf(numbers);
            SortSolution solution = new SortSolution(sort, copy, true, false);
            long start = System.nanoTime();
            solution.sort();
            long end = System.nanoTime();
            container[i] = end - start;
        }
        return sum(container) / (double) time;
    }



    /**
     * This method initialize a random integer array.
     *
     * @param size size of array.
     * @return a random integer array.
     * */
    public static int[] initializeArray(int size){
        int[]  numbers = new int[size];
        Random random  = new Random();
        for (int i = 0; i < size; i++){
            numbers[i] = random.nextInt((int) Math.pow(10, 6)) + 1;
        }
        return numbers;
    }
    public static void main(String[] args) {
        final int TIME = 20;
        final int[] SIZES = new int[]{100, 1000, 10000, 100000};
        final Sort[] SORTS = new Sort[]{new QuickSort(), new MergeSort(), new ShellSort(), new BubbleSort(), new InsertionSort(), new SelectionSort(), };
        for (int size: SIZES) {
            int[] numbers = initializeArray(size);
            System.out.println("Size: " + size);
            for (Sort sort: SORTS) {
                System.out.println("Average Execution Time in sorting array using " + sort.getClass().getSimpleName() +
                                   " with size " + size + " in " + TIME + " time run: ~"
                                   + runtime(sort, numbers, TIME) + "(nano second)");
            }
            System.out.println("________________________");
        }
    }
}
