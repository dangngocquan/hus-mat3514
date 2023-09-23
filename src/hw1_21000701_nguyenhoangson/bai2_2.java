package hw1_21000701_nguyenhoangson;

import java.util.Scanner;

public class bai2_2 {
	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

	public static <T> void printArray(T[] arr) {
		for (T element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập số lượng phần tử trong mảng: ");
		int n = scanner.nextInt();

		Integer[] arr = new Integer[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
			arr[i] = scanner.nextInt();
		}

		System.out.println("Các số chẵn trong mảng là:");
		for (int i = 0; i < n; i++) {
			if (isEven(arr[i])) {
				System.out.print(arr[i] + " ");
			}
		}

		// In ra toàn bộ mảng sử dụng generic
		System.out.println("\nCác phần tử trong mảng:");
		printArray(arr);

		scanner.close();
	}
}
