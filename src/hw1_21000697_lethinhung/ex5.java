package hw1_21000697_lethinhung;

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter quantity of lines: ");
        int quantity = scanner.nextInt();
        String[] str = new String[quantity];
        scanner.nextLine();

        for (int i = 0; i < str.length; i++) {
            str[i] = scanner.nextLine();
        }

        System.out.println("Input: ");
        for (String s : str) {
            System.out.println(s);
        }

        System.out.println("Reverse: ");
        for (int i = str.length - 1; i >= 0; i--) {
            System.out.println(str[i]);
        }
    }
}
