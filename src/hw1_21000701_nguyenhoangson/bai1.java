package hw1_21000701_nguyenhoangson;

import java.util.Scanner;

public class bai1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Nhập một số nguyên
		System.out.print("Nhập một số nguyên: ");
		int soNguyen = scanner.nextInt();

		// Nhập một số thực (double)
		System.out.print("Nhập một số thực: ");
		double soThuc = scanner.nextDouble();

		// Nhập một ký tự
		System.out.print("Nhập một ký tự: ");
		char kyTu = scanner.next().charAt(0); // Lấy ký tự đầu tiên trong chuỗi nhập

		// Nhập một giá trị boolean
		System.out.print("Nhập một giá trị boolean (true hoặc false): ");
		boolean giaTriBoolean = scanner.nextBoolean();

		// In ra các giá trị đã nhập
		System.out.println("Số nguyên đã nhập: " + soNguyen);
		System.out.println("Số thực đã nhập: " + soThuc);
		System.out.println("Ký tự đã nhập: " + kyTu);
		System.out.println("Giá trị boolean đã nhập: " + giaTriBoolean);

		// Đóng scanner
		scanner.close();
	}
}
