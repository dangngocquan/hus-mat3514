package hw2_20001970_duongtuanson.Bai1;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu cua mang: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomNum = rand.nextInt(1000000);
            arr[i] = randomNum;
        }
        int [] arr1 = arr.clone();
        int [] arr2 = arr.clone();
        int [] arr3 = arr.clone();
        int [] arr4 = arr.clone();
        System.out.println("Mang ban dau: ");
        System.out.println(Arrays.toString(arr));
        bSort(arr);
        sSort(arr1);
        iSort(arr2);
        mSort(arr3);
        qSort(arr4);
        System.out.println("Mang sau khi sap xep: ");
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr) {
        BubbleSort.bubbleSort(arr);
    }
    public static void selectionSort(int[] arr) {
        SelectionSort.selectionSort(arr);
    }
    public static void insertionSort(int[] arr) {
        InsertionSort.insertionSort(arr);
    }
    public static void mergeSort(int[] arr) {
        MergeSort.mergeSort(arr);
    }
    public static void quickSort(int[] arr) {
        QuickSort.quickSort(arr);
    }

    public static void bSort(int[] arr) {
        long start = System.currentTimeMillis();
        bubbleSort(arr);
//        System.out.println("bubbleSort :" +Arrays.toString(arr));
        long end = System.currentTimeMillis();
        System.out.println("Bubble sort: " + (end - start) + "ms");
    }
    public static void sSort(int[] arr1) {
        long start = System.currentTimeMillis();
        selectionSort(arr1);
//        System.out.println("selectionSort :" +Arrays.toString(arr1));
        long end = System.currentTimeMillis();
        System.out.println("Selection sort: " + (end - start) + "ms");
    }
    public static void iSort(int[] arr2) {
        long start = System.currentTimeMillis();
        insertionSort(arr2);
//        System.out.println("insertionSort :" +Arrays.toString(arr2));
        long end = System.currentTimeMillis();
        System.out.println("Insertion sort: " + (end - start) + "ms");
    }
    public static void mSort(int[] arr3) {
        long start = System.currentTimeMillis();
        mergeSort(arr3);
//        System.out.println("mergeSort :" +Arrays.toString(arr3));
        long end = System.currentTimeMillis();
        System.out.println("Merge sort: " + (end - start) + "ms");
    }

    public static void qSort(int[] arr4) {
        long start = System.currentTimeMillis();
        quickSort(arr4);
//        System.out.println("quickSort :" +Arrays.toString(arr4));
        long end = System.currentTimeMillis();
        System.out.println("Quick sort: " + (end - start) + "ms");
    }
}
