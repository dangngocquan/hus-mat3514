package hw4_21000117_nguyenquochieu.exercise03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input an expression: ");
        String expression = scanner.nextLine();
        ExpressionCalculator calculator = new ExpressionCalculator(expression);
        System.out.println(expression + " = " + calculator.calculate());
    }
}
