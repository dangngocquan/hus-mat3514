package hw5_21000699_dangngocquan.extend001.task053;

import java.util.Scanner;

// Link: https://codelearn.io/learning/data-structure-and-algorithms?activityType=12&activityId=1298
public class CalculateAPowerB {
    // Calculate a^b
    // Return null if overflow or a < 0 or b < 0 (Condition of problem: a >= 0, b >= 0)
    public static Long pow(long a, long b) {
        if (a < 0 || b < 0) return null; // Condition of problem
        if (b == 0) return (long) 1;
        Long f1 = pow(a, b-1);
        if (f1 == null) return null;
        Long f0 = a * f1;
        if (f0 < f1) return null; // Overflow
        return f0;
    }

    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        scanner.close();
        // Output
        System.out.println(pow(a, b));
    }
}
