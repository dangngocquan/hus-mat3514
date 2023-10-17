package hw3_21000506_nguyenthithanhhuong.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestProgram {
    public TestProgram() {
        Scanner sc = new Scanner(System.in);

        // Read a fraction list by keyboard
        List<Fraction> list = createFractionList(sc);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Print fraction by index
        printFraction(sc, list);
        sc.close();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Add n fractions of list and print result
        System.out.println("Add fractions...");
        Fraction sum = addFractionList(list);
        System.out.printf("Sum of n fractions: %s\n", sum.toString());

        // Minus n fractions of list and print result
        System.out.println("Minus fractions...");
        Fraction different = minusFractionList(list);
        System.out.printf("Different of n fractions: %s\n", different.toString());

        // Multiply n fractions of list and print result
        System.out.println("Multiply fractions...");
        Fraction product = multiFractionList(list);
        System.out.printf("Product of n fractions: %s\n", product.toString());

        // Divide n fractions of list and print result
        System.out.println("Divide fractions...");
        Fraction quotient = diviFractionList(list);
        if (quotient != null) {
            System.out.printf("Quotient of n fractions: %s\n", quotient.toString());
        } else {
            System.out.println(quotient);
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Other condition
        // Find max fraction of fractions list
        System.out.printf("The max fraction of this fraction list: %s", getMaxFraction(list).toString());
    }

    // Create fraction list by keyboard
    public List<Fraction> createFractionList(Scanner sc) {
        // Enter the length of fraction list
        System.out.print("Enter the fractional quantity: ");
        int n = sc.nextInt();

        List<Fraction> list = new ArrayList<>();

        // Enter elements of fraction list
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the fraction %d:\n", i + 1);
            System.out.print("Enter the numerator of this fraction: ");
            float numerator = sc.nextFloat();
            System.out.print("Enter the denominator of this fraction: ");
            float denominator = sc.nextFloat();
            // Check input element is a fraction or not
            // If denominator of input fraction equals 0 -> enter this fraction again
            if (Float.compare(denominator, 0) == 0) {
                while (Float.compare(denominator, 0) == 0) {
                    System.out.printf("Enter the fraction %d again:\n", i + 1);
                    System.out.print("Enter the numerator of this fraction: ");
                    numerator = sc.nextFloat();
                    System.out.print("Enter the denominator of this fraction: ");
                    denominator = sc.nextFloat();
                }
            }
            list.add(new Fraction(numerator, denominator));
        }
        return list;
    }

    // Print fraction at key position
    public void printFraction(Scanner sc, List<Fraction> list) {
        System.out.println("Enter the key of fraction you want to print: ");
        int key = sc.nextInt();
        System.out.printf("Fraction %d: %s\n", key, list.get(key - 1).toString());
    }

    // Add n fractions of fraction list
    public Fraction addFractionList(List<Fraction> list) {
        Fraction result = Fraction.normalize(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            result = result.add(list.get(i));
        }
        return result;
    }

    // Minus n fractions of fraction list
    public Fraction minusFractionList(List<Fraction> list) {
        Fraction result = Fraction.normalize(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            result = result.minus(list.get(i));
        }
        return result;
    }

    // Multiply n fractions of fraction list
    public Fraction multiFractionList(List<Fraction> list) {
        Fraction result = Fraction.normalize(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            result = result.multi(list.get(i));
        }
        return result;
    }

    // Divide n fractions of fraction list
    public Fraction diviFractionList(List<Fraction> list) {
        Fraction result = Fraction.normalize(list.get(0));
        try {
            for (int i = 1; i < list.size(); i++) {
                result = result.divi(list.get(i));
            }
        } catch (NullPointerException e) {
        }
        return result;
    }

    // Find max fraction of fraction list
    public Fraction getMaxFraction(List<Fraction> list) {
        int maxIdx = 0;

        for (int i = 1; i < list.size(); i++) {
            Fraction maxFrac = Fraction.normalize(list.get(maxIdx));
            Fraction idxFrac = Fraction.normalize(list.get(i));

            float maxNumerator = maxFrac.getNumerator();
            float maxDenominator = maxFrac.getDenominator();
            float idxNumerator = idxFrac.getNumerator();
            float idxDenominator = idxFrac.getDenominator();

            if (Float.compare(maxDenominator, 0) < 0) {
                maxNumerator = maxNumerator * -1;
                maxDenominator = maxDenominator * -1;
            }

            if (Float.compare(idxDenominator, 0) < 0) {
                idxNumerator = idxNumerator * -1;
                idxDenominator = idxDenominator * -1;
            }

            if (Float.compare(maxNumerator*idxDenominator, idxNumerator*maxDenominator) < 0) {
                maxIdx = i;
            }
        }
        return list.get(maxIdx);
    }
}