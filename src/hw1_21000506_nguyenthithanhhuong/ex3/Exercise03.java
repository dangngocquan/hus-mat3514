package hw1_21000506_nguyenthithanhhuong.ex3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Complex complex1 = new Complex(1, 4);
        Complex complex2 = new Complex(8, -2);
        Complex complex3 = new Complex(5, 9);

        // Print complex
        System.out.println("Input complex...");
        System.out.print("Complex 1: " + complex1.toString() + "\n");
        System.out.print("Complex 2: " + complex2.toString() + "\n");
        System.out.print("Complex 3: " + complex3.toString() + "\n");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Add, multiply two complexes
        System.out.println("Add, multiply two complexes...");

        // Add two complexes
        System.out.println("Sum of complex 1 and complex 2:");
        Complex sumTwoComplex = complex1.sumTwoComplex(complex2);
        System.out.println(sumTwoComplex.toString());

        // Multiply two complexes
        System.out.println("Product of complex 1 and complex 2:");
        Complex productTwoComplex = complex1.productTwoComplex(complex2);
        System.out.println(productTwoComplex.toString());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Create a complexes list
        List<Complex> listComplex = new ArrayList<>();
        listComplex.add(complex1);
        listComplex.add(complex2);
        listComplex.add(complex3);

        // Add, multiply complexes
        System.out.println("Add, multiply complexes...");

        // Add complexes
        System.out.println("Sum of three complex (complex 1, complex 2, complex 3):");
        Complex result1 = Complex.sumComplexes(listComplex);
        if (result1 != null) {
            System.out.println(result1.toString());
        } else {
            System.out.println("null...");
        }

        // Multiply complexes
        System.out.println("Product of three complex (complex 1, complex 2, complex 3):");
        Complex result2 = Complex.productComplexes(listComplex);
        if (result2 != null) {
            System.out.println(result2.toString());
        } else {
            System.out.println("null...");
        }
    }

    // Result
    /*
    Input complex...
    Complex 1: 1.0 + 4.0i
    Complex 2: 8.0 - 2.0i
    Complex 3: 5.0 + 9.0i
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Add, multiply two complexes...
    Sum of complex 1 and complex 2:
    9.0 + 2.0i
    Product of complex 1 and complex 2:
    16.0 + 30.0i
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Add, multiply complexes...
    Sum of three complex (complex 1, complex 2, complex 3):
    14.0 + 11.0i
    Product of three complex (complex 1, complex 2, complex 3):
    -484.0 + 104.0i
    */
}
