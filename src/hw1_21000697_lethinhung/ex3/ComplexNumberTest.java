package hw1_21000697_lethinhung.ex3;

import java.util.Scanner;

public class ComplexNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Add, multiply two complex numbers
        System.out.println("First complex number:");
        System.out.print("Real: ");
        double real1 = scanner.nextDouble();
        System.out.print("Imag: ");
        double imag1 = scanner.nextDouble();
        ComplexNumber complexNumber1 = new ComplexNumber(real1, imag1);
        System.out.println("Complex1: " + complexNumber1);

        System.out.println("Second complex number:");
        System.out.print("Real: ");
        double real2 = scanner.nextDouble();
        System.out.print("Imag: ");
        double imag2 = scanner.nextDouble();
        ComplexNumber complexNumber2 = new ComplexNumber(real2, imag2);
        System.out.println("Complex2: " + complexNumber2);

        ComplexNumber sum = complexNumber1.add(complexNumber2);
        System.out.println("Sum of two complex numbers: " + sum);

        ComplexNumber product = complexNumber1.multiply(complexNumber2);
        System.out.println("Product of two complex numbers: " + product);


        // Add, Multiply some complex numbers
        System.out.print("Quantity: ");
        int num = scanner.nextInt();

        ComplexNumber[] complexNumbers = new ComplexNumber[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Complex number " + (i + 1) + ": ");
            System.out.print("Real: ");
            double real = scanner.nextDouble();
            System.out.print("Imag: ");
            double imag = scanner.nextDouble();
            complexNumbers[i] = new ComplexNumber(real, imag);
        }

        System.out.println("Complex numbers: ");
        for (int i = 0; i < num; i++) {
            System.out.println(complexNumbers[i]);
        }

        ComplexNumber sum1 = new ComplexNumber(0, 0);
        for (int i = 0; i< num; i++) {
            sum1 = sum.add(complexNumbers[i]);
        }
        System.out.println("Sum of " + num + " complex numbers: " + sum1);

        ComplexNumber product1 = new ComplexNumber(1,0);
        for (int i = 0; i < num; i++) {
            product1 = product1.multiply(complexNumbers[i]);
        }
        System.out.println("Product of " + num + " complex numbers: " + product1);

    }
}
