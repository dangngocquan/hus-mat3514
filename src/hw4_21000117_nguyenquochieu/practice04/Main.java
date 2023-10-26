package hw4_21000117_nguyenquochieu.practice04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string: ");
        String input = scanner.nextLine();
        Solution solution = new Solution();
        System.out.println(solution.isValid(input));
    }
}
