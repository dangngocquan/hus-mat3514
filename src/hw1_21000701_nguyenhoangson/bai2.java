package hw1_21000701_nguyenhoangson;

import java.util.Scanner;

public class bai2 {
	// Hàm kiểm tra xem một số có phải là số nguyên tố hay không
	public static boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}
		if (number <= 3) {
			return true;
		}
		if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}
		for (int i = 5; i * i <= number; i = i + 6) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Nhập số lượng phần tử trong mảng
		System.out.print("Nhập số lượng phần tử trong mảng: ");
		int n = scanner.nextInt();

		// Khởi tạo mảng số nguyên
		int[] arr = new int[n];

		// Nhập dãy số nguyên
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
			arr[i] = scanner.nextInt();
		}

		// In ra các số nguyên tố trong mảng
		System.out.println("Các số nguyên tố trong mảng là:");
		for (int i = 0; i < n; i++) {
			if (isPrime(arr[i])) {
				System.out.print(arr[i] + " ");
			}
		}

		scanner.close();
	}
}
