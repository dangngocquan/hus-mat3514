package hw5_21000699_dangngocquan.extend001.task052;

import java.util.Scanner;

// Link: https://codelearn.io/learning/data-structure-and-algorithms?activityType=12&activityId=1297
public class CalculateFactorial {
    // Calculate n!
    // Return null if overflow
    public static Long factorial(long n) {
        if (n < 0) return null;
        if (n == 0) return (long) 1;
        Long f1 = factorial(n-1);
        if (f1 == null) return null;
        Long f0 = n * f1;
        if (f0 < f1) return null; // Check overflow
        return f0;
    }

    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        // Output
        System.out.println(factorial(n));
    }
}
