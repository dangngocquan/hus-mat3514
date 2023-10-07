package hw2_22001273_nguyenhoangminh.excercise2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestSortGeneric {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Input the length of the array: ");
        int length = input.nextInt();

        System.out.println("Unsorted array: ");
        Integer[] intArray = new Integer[length];
        for (int i=0; i<10; i++) {
            intArray[i] = (Integer)rand.nextInt(100);
        }
        // Create generic array of type T. 
        GenericArray array = new GenericArray(intArray);

        System.out.println(Arrays.toString(array.getArray()));

        // Create sorter object
        SortGeneric sorter = new SortGeneric();

        sorter.quickSort(array.getArray(), 0, length-1);
        // Print the array after sorting
        System.out.println(Arrays.toString(array.getArray()));
        input.close();
    }    
}
