package hw2_21000506_nguyenthithanhhuong.ex5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of array: ");
        int length = sc.nextInt();

        int[] array = new int[length];

        System.out.println("Enter elements of array: ");
        createArrayByKeyboard(sc, array);
        sc.close();

        System.out.println("Input array: ");
        System.out.println(printArray(array));

        bubbleSort(array);
        System.out.println("Output array: ");
        System.out.println(printArray(array));
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSort = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] < array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    isSort = false;
                }
            }
            if (isSort) return;
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
//    Enter elements of array:
//    91 451 43 3 451 54
//    Input array:
//    [91, 451, 43, 3, 451, 54]
//    Array after sort:
//    [451, 451, 91, 54, 43, 3]
}
