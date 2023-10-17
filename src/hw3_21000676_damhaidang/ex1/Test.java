package hw3_21000676_damhaidang.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Fraction> list;
        list = generate(sc);

        System.out.println("Tổng tất cả các phẩn tử trong dãy là: " + add(list));
        System.out.println("Hiệu tất cả các phẩn tử trong dãy là: " + minus(list));
        System.out.println("Tích tất cả các phẩn tử trong dãy là: " + multi(list));
        System.out.println("Thương tất cả các phẩn tử trong dãy là: " + divide(list));
        System.out.println("Phần từ lớn nhất trong dãy là: " + maxElement(list));
    }

    // Tạo dãy các phân số
    public static List<Fraction> generate(Scanner scanner) {
        int length = scanner.nextInt();
        List<Fraction> list = new ArrayList<Fraction>();
        for (int i = 0; i < length; i++) {
            float numerator = scanner.nextFloat();
            float denominator = scanner.nextFloat();
            list.add(new Fraction(numerator, denominator));
        }
        return list;
    }

    // In các phần tử trong dãy
    public static void printElements(List<Fraction> list, int v) {
        System.out.println(list.get(v));
    }

    // Hiệu tất cả các phân số trong dãy
    public static Fraction add(List<Fraction> list) {
        Fraction result = new Fraction(0, 1);
        for (Fraction f: list) {
            result = result.add(f);
        }
        return result.normalized();
    }

    // Hiệu tất cả các phân số trong dãy
    public static Fraction minus(List<Fraction> list) {
        Fraction result = list.get(0);
        for (int idx = 1; idx < list.size(); idx++) {
            result = result.minus(list.get(idx));
        }
        return result.normalized();

    }

    // Tích tất cả các phân số trong dãy
    public static Fraction multi(List<Fraction> list) {
        Fraction result = new Fraction(1, 1);
        for (Fraction f: list) {
            result = result.multi(f);
        }
        return result.normalized();

    }

    // Thương của phần tử thứ nhất với các phẩn tử còn lại trong dãy
    public static Fraction divide(List<Fraction> list) {
        Fraction result = list.get(0);
        for (int idx = 1; idx < list.size(); idx++) {
            result = result.divi(list.get(idx));
        }
        return result.normalized();

    }

    // Tìm giá trị lớn nhất trong dãy
    public static Fraction maxElement(List<Fraction> list) {
        Fraction result = list.get(0);
        float valueOfResult = result.getNumerator() / result.getDenominator();
        for (Fraction f : list) {
            float valueOfFraction = f.getNumerator() / f.getDenominator();
            if (valueOfResult < valueOfFraction) {
                result = f;
            }
        }
        return result.normalized();
    }
}
