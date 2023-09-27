package hw1_21000245_nguyenthihaphuong.Exercise3;

import java.util.Scanner;

public class ComplexCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of complex numbers: ");
        int numComplexNumbers = scanner.nextInt();

        ComplexNumbers[] complexNumbers = new ComplexNumbers[numComplexNumbers];

        for (int i = 0; i < numComplexNumbers; i++) {
            System.out.println("Enter complex number " + (i + 1) + ":");
            System.out.print("Real part: ");
            double realPart = scanner.nextDouble();
            System.out.print("Imaginary part: ");
            double imaginaryPart = scanner.nextDouble();
            complexNumbers[i] = new ComplexNumbers(realPart, imaginaryPart);
        }

        ComplexNumbers sum = new ComplexNumbers(0, 0);
        ComplexNumbers product = new ComplexNumbers(1, 0);

        for (ComplexNumbers complexNumber : complexNumbers) {
            sum = sum.add(complexNumber);
            product = product.multiply(complexNumber);
        }

        System.out.println();
        System.out.println("Complex numbers: ");
        for (ComplexNumbers complexNumbers1 : complexNumbers) {
            System.out.print(complexNumbers1 + ", ");
        }

        System.out.println();
        System.out.println("Sum of complex numbers: " + sum);
        System.out.println("Product of complex numbers: " + product);

        scanner.close();
    }
}
