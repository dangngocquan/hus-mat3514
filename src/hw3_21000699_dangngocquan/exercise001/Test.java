package hw3_21000699_dangngocquan.exercise001;

import java.util.*;

public class Test {
    public Test() {
        Scanner scanner = new Scanner(System.in);
        List<Fraction> fractions = createFractions(scanner);
        System.out.println("------------------------------------------");
        showOneFraction(scanner, fractions);
        System.out.println("------------------------------------------");
        showSumOfFractions(fractions);
        System.out.println("------------------------------------------");
        showMinusOfFractions(fractions);
        System.out.println("------------------------------------------");
        showMultiOfFractions(fractions);
        System.out.println("------------------------------------------");
        showDivOfFractions(fractions);
        System.out.println("------------------------------------------");
        showMaxFraction(fractions);

        scanner.close();
    }

    public List<Fraction> createFractions(Scanner scanner) {
        System.out.print("Enter number of fractions: ");
        int n = scanner.nextInt();
        List<Fraction> fractions = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            System.out.println("Fraction " + (i+1) + ": ");
            System.out.printf("%-12s = ", "\tNumerator");
            float numerator = scanner.nextFloat();
            System.out.printf("%-12s = ", "\tDenominator");
            float denominator = scanner.nextFloat();
            fractions.add(new Fraction(numerator, denominator));
        }
        return fractions;
    }

    public void showOneFraction(Scanner scanner, List<Fraction> fractions) {
        System.out.printf("Enter index of fraction which you want to show [%d, %d]: ", 0, fractions.size() - 1);
        int index = scanner.nextInt();
        System.out.println(fractions.get(index));
    }

    public void showSumOfFractions(List<Fraction> fractions) {
        if (fractions.size() > 0) {
            Fraction fraction = fractions.get(0);
            for (int i = 1; i < fractions.size(); i++) {
                fraction = fraction.add(fractions.get(i));
            }
            System.out.println("Sum of fractions = " + fraction);
        } else {
            System.out.println("Sum of fractions = 0");
        }
    }

    public void showMinusOfFractions(List<Fraction> fractions) {
        if (fractions.size() > 0) {
            Fraction fraction = fractions.get(0);
            for (int i = 1; i < fractions.size(); i++) {
                fraction = fraction.minus(fractions.get(i));
            }
            System.out.println("Minus of fractions = " + fraction);
        } else {
            System.out.println("Minus of fractions = 0");
        }
    }

    public void showMultiOfFractions(List<Fraction> fractions) {
        if (fractions.size() > 0) {
            Fraction fraction = fractions.get(0);
            for (int i = 1; i < fractions.size(); i++) {
                fraction = fraction.multi(fractions.get(i));
            }
            System.out.println("Multi of fractions = " + fraction);
        } else {
            System.out.println("Multi of fractions = 0");
        }
    }

    public void showDivOfFractions(List<Fraction> fractions) {
        if (fractions.size() > 0) {
            Fraction fraction = fractions.get(0);
            for (int i = 1; i < fractions.size(); i++) {
                fraction = fraction.div(fractions.get(i));
                if (fraction == null) return;
            }
            System.out.println("Div of fractions = " + fraction);
        } else {
            System.out.println("Div of fractions = 0");
        }
    }

    public Fraction getMaxFraction(List<Fraction> fractions) {
        List<Fraction> fractions0 = new ArrayList<>(fractions);
        Collections.sort(fractions0, new Comparator<Fraction>() {
            @Override
            public int compare(Fraction o1, Fraction o2) {
                Fraction f1 = o1.normalize();
                Fraction f2 = o2.normalize();
                return (int) (f1.getNumerator()*f2.getDenominator() - f2.getNumerator()*f1.getDenominator());
            }
        });
        return fractions0.get(fractions0.size()-1);
    }

    public void showMaxFraction(List<Fraction> fractions) {
        Fraction fraction = getMaxFraction(fractions);
        System.out.println("Maximum fraction: " + fraction);
    }

}
