package hw2_21000709_hoangtuantu.exercise01;

import java.util.*;
/**
 * @author Hoang Tuan Tu
 *
 * This class performs checks to verify if the sorting methods are correct or not.
 * */

public class Main {

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
     * Checks if all the integer arrays in a List are the same.
     * This method compares each pair of integer arrays in the input List to determine if they are equal. If any pair of arrays is found to be different, the method returns false. If all pairs of arrays are the same, the method returns true.
     *
     * @param arrayNumbers A List of integer arrays to be checked for equality.
     * @return true if all integer arrays in the List are the same, false otherwise.
     */

    public static boolean allSame(List<int[]> arrayNumbers){
        for (int i = 0; i < arrayNumbers.size() - 1; i++) {
            for (int j = i + 1; j < arrayNumbers.size(); j++) {
                if (!Arrays.equals(arrayNumbers.get(i), arrayNumbers.get(j))) {
                    return false;
                }
            }

        }
        return true;
    }


    /**
     * Sorts an array of integers using a specified sorting algorithm.
     * This method takes an array of integers and sorts it using the provided sorting algorithm. It also provides the option to sort the array in ascending or descending order and to display each step of the sorting process if desired.
     *
     * @param numbers The array of integers to be sorted.
     * @param sort An instance of a sorting algorithm that implements the Sort interface.
     * @param ascending If true, the array will be sorted in ascending order; if false, it will be sorted in descending order.
     * @param stepByStep If true, the sorting process will be displayed step by step; if false, it will not be displayed.
     * @return The sorted array of integers.
     */
    public static int[] usingSort(int[] numbers, Sort sort, boolean ascending, boolean stepByStep){
        System.out.println(sort.getClass().getSimpleName()); // Print out using type!
        int[] result = copyOf(numbers); // Copy array
        SortSolution solution = new SortSolution(sort, result, ascending, stepByStep); // Using Sort
        long start = System.nanoTime(); // Begin timing
        solution.sort(); // Sorting Array
        long end = System.nanoTime(); // End timing
        System.out.println("Runtime: " + ((end - start) / 1000.0) + "(ms)" ); // print out result
        System.out.println("______________");
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input size of array: ");
        int size = input.nextInt(); // input size of array
        input.close();
        int[] numbers = initializeArray(size); // initialize array
        List<int[]>  arrayNumber = new ArrayList<>(); // initialize lít to contain all result

        System.out.println("______________");

        boolean ascending = true; // Ascending filed
        boolean stepByStep = true; // Ascending filed
        Sort[] sorts = new Sort[]{ new BubbleSort(), new InsertionSort(), new MergeSort(),
                new QuickSort(), new SelectionSort(), new ShellSort()}; // All sort way to test

        for (Sort sort: sorts){
            arrayNumber.add(usingSort(numbers, sort, ascending, stepByStep)); // add array to list for checking
        }

        if (allSame(arrayNumber)){
            /* If all sorting way have same result print out array number*/
            System.out.println("Result: ");
            System.out.println(Arrays.toString(arrayNumber.get(0)));
        }else {
            /* else print warning to fix*/
            System.out.println("Something went wrong!");
        }
    }
}
