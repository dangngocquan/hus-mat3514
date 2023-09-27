package hw1_21002169_nguyenngocquy;

import java.util.Scanner;

public class Ex2 {
    public static int[] inputArray(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so phan tu: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        sc.close();
        return arr;
    }
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void printPrime(int arr[]){
        for (int i=0; i<arr.length; i++){
            if (isPrime(arr[i])){
                System.out.println("Cac so nguyen to trong mang la: " + arr[i]);
            }
        }
    }
    public static void printEvenNumbers(int[] array) {
        System.out.print("Cac so chan trong mang la: ");
        for (int number : array) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = inputArray();

        printPrime(arr);

        printEvenNumbers(arr);

        Double[] doubleArray = {1.2, 3.5, 4.7, 9.6};
        String[] stringArray = {"Dog", "One", "Pink", "Flour"};

        System.out.println("\nCac phan tu trong mang so thuc:");
        printArray(doubleArray);

        System.out.println("\nCac phan tu trong mang chuoi:");
        printArray(stringArray);

    }
}






