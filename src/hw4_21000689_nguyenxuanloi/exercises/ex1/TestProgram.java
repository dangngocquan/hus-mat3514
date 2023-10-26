package hw4_21000689_nguyenxuanloi.exercises.ex1;

import java.util.Scanner;
import java.util.Stack;

public class TestProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        sc.close();
        doSomethingWithString(name);
    }

    static void doSomethingWithString(String hoten) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0) {
                s.push(hoten.charAt(i));
            }
            if (i % 3 == 0) {
                s.pop();
            }
        }
        printStack(s);
    }

    static <T> void printStack(Stack<T> s) {
        for (T element: s) {
            System.out.print(element);
        }
        System.out.println();
    }
}
