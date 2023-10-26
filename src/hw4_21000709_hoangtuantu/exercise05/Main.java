package hw4_21000709_hoangtuantu.exercise05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a string to check: ");
        String str = input.nextLine();

        if (Palindrome.isPalindrome(str)){
            System.out.println("\"" + str + "\" is a Palindrome string!");
        }else{
            System.out.println("\"" + str + "\" is not a Palindrome string!");
        }
    }
}
