package hw3_20000550_duongduyhieu.Bai1;

import java.util.Scanner;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0.");
        }
    }

    // Phương thức cộng phân số
    public Fraction add(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        return new Fraction(newNumerator, commonDenominator).normalize();
    }

    // Phương thức trừ phân số
    public Fraction subtract(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        return new Fraction(newNumerator, commonDenominator).normalize();
    }

    // Phương thức nhân phân số
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    // Phương thức chia phân số
    public Fraction divide(Fraction other) {
        if (other.numerator != 0) {
            int newNumerator = this.numerator * other.denominator;
            int newDenominator = this.denominator * other.numerator;
            return new Fraction(newNumerator, newDenominator).normalize();
        } else {
            throw new IllegalArgumentException("Không thể chia cho 0.");
        }
    }

    // Phương thức tối giản phân số
    public Fraction normalize() {
        int gcd = greatestCommonDivisor(this.numerator, this.denominator);
        return new Fraction(this.numerator / gcd, this.denominator / gcd);
    }

    // Phương thức tính ước chung lớn nhất (GCD)
    private int greatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return greatestCommonDivisor(b, a % b);
        }
    }

    // Phương thức lấy tử số
    public int getNumerator() {
        return numerator;
    }

    // Phương thức lấy mẫu số
    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Phương thức tính trung bình của danh sách phân số
    public static Fraction calculateAverage(Fraction[] fractions) {
        int sumNumerator = 0;
        int commonDenominator = 1;

        // Tính tổng các tử số và tìm chung mẫu số
        for (Fraction fraction : fractions) {
            sumNumerator += fraction.getNumerator();
            commonDenominator *= fraction.getDenominator();
        }

        // Tạo phân số kết quả bằng cách chia tổng tử số cho n
        return new Fraction(sumNumerator, commonDenominator * fractions.length).normalize();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập số phân số (n): ");
            int n = scanner.nextInt();

            Fraction[] fractions = new Fraction[n];

            // Nhập các phân số từ người dùng và lưu vào mảng
            for (int i = 0; i < n; i++) {
                System.out.println("Nhập phân số thứ " + (i + 1) + ": ");
                System.out.print("Tử số: ");
                int numerator = scanner.nextInt();
                System.out.print("Mẫu số (khác 0): ");
                int denominator = scanner.nextInt();
                fractions[i] = new Fraction(numerator, denominator);
            }

            // In ra phân số ở vị trí thứ v
            System.out.print("Nhập vị trí của phân số cần in ra (0-based): ");
            int v = scanner.nextInt();

            if (v >= 0 && v < n) {
                System.out.println("Phân số ở vị trí thứ " + v + ": " + fractions[v]);
            } else {
                System.out.println("Vị trí không hợp lệ.");
            }

            // Tính tổng của n phân số và in ra kết quả
            Fraction sum = new Fraction(0, 1);
            for (Fraction fraction : fractions) {
                sum = sum.add(fraction);
            }
            System.out.println("Tổng của n phân số: " + sum);

            // Tính và in ra phân số trung bình của danh sách
            Fraction average = calculateAverage(fractions);
            System.out.println("Phân số trung bình của danh sách: " + average);

            // Thực hiện các phép tính khác (trừ, nhân, chia) và in ra kết quả
            System.out.print("Nhập vị trí phân số thứ nhất cho phép tính (0-based): ");
            int index1 = scanner.nextInt();
            System.out.print("Nhập vị trí phân số thứ hai cho phép tính (0-based): ");
            int index2 = scanner.nextInt();

            if (index1 >= 0 && index1 < n && index2 >= 0 && index2 < n) {
                Fraction resultAdd = fractions[index1].add(fractions[index2]);
                Fraction resultSubtract = fractions[index1].subtract(fractions[index2]);
                Fraction resultMultiply = fractions[index1].multiply(fractions[index2]);
                Fraction resultDivide = fractions[index1].divide(fractions[index2]);

                System.out.println("Kết quả cộng: " + resultAdd);
                System.out.println("Kết quả trừ: " + resultSubtract);
                System.out.println("Kết quả nhân: " + resultMultiply);
                System.out.println("Kết quả chia: " + resultDivide); }
        }
        }
    }
