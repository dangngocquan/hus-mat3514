package hw1_21002169_nguyenngocquy;

import java.util.Scanner;

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }

    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }
}

public class ComplexManyNumberOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so so phuc: ");
        int n = scanner.nextInt();

        ComplexNumber[] complexNumbers = new ComplexNumber[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan thuc " + (i + 1) + ": ");
            double realPart = scanner.nextDouble();
            System.out.print("Nhap phan ao " + (i + 1) + ": ");
            double imaginaryPart = scanner.nextDouble();
            complexNumbers[i] = new ComplexNumber(realPart, imaginaryPart);
        }

        ComplexNumber sum = new ComplexNumber(0, 0);
        for (ComplexNumber complexNumber : complexNumbers) {
            sum = sum.add(complexNumber);
        }

        ComplexNumber product = new ComplexNumber(1, 0);
        for (ComplexNumber complexNumber : complexNumbers) {
            product = product.multiply(complexNumber);
        }

        System.out.println("Tong cua cac so phuc la: " + sum);
        System.out.println("Tich cua cac so phuc la: " + product);
    }
}