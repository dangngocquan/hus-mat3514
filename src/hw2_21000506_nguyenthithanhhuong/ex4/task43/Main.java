package hw2_21000506_nguyenthithanhhuong.ex4.task43;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Input
        int length = sc.nextInt();

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();

        //Solve
        selectionSort(array);

        //Output
        printArray(array);
    }

    public static void selectionSort(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = array[i];
            array[i] = array[maxIdx];
            array[maxIdx] = temp;
        }
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
