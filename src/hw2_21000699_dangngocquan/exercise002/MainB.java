package hw2_21000699_dangngocquan.exercise002;

import hw2_21000699_dangngocquan.exercise002.service.generator.Generator;
import hw2_21000699_dangngocquan.exercise002.service.sort.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class MainB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        Integer[] a = Generator.randomArray(n, 1, 1000001);
        System.out.printf("%-15s: %s\n", "Initial array", Arrays.toString(a));
        scanner.close();

        System.out.println("\nSort ...");

        System.out.println("1. Bubble sort:");
        Sort.bubbleSort(a.clone());

        System.out.println("\n2. Selection sort:");
        Sort.selectionSort(a.clone());

        System.out.println("\n3. Insertion sort:");
        Sort.insertionSort(a.clone());

        System.out.println("\n4. Merge sort:");
        Sort.mergeSort(a.clone());

        System.out.println("\n5. Quick sort:");
        Sort.quickSort(a.clone());
    }
}
