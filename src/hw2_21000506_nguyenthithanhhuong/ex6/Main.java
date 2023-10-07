package hw2_21000506_nguyenthithanhhuong.ex6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.println("Enter the length of array: ");
        int length = sc.nextInt();

        System.out.println("Enter the key: ");
        int key = sc.nextInt();

        int[] array = new int[length];

        System.out.println("Enter elements of array: ");
        createArrayByKeyboard(sc, array);
        sc.close();

        System.out.println("Input array: ");
        System.out.println(printArray(array));

        selectionSort(array);

        //Output
        System.out.println("Result: ");
        System.out.println(array[key - 1]);
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

    public static void createArrayByKeyboard(Scanner sc, int[] array) {
        int i = 0;
        while (i < array.length) {
            array[i] = sc.nextInt();
            i++;
        }
    }

    public static String printArray(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[array.length - 1]).append("]");
        return sb.toString();
    }

//    Example run program
//    Enter the length of array:
//    6
//    Enter the key:
//    4
//    Enter elements of array:
//    91 451 43 3 452 54
//    Input array:
//    [91, 451, 43, 3, 452, 54]
//    Result:
//    91
}
