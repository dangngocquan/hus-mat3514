package hw4_21000506_nguyenthithanhhuong.ex01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String hoten = input();

        Stack s = new ArrayStack<>(15);

        test(hoten, s);

        System.out.println("Result: " + s.toString());
    }

    public static String input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your full name (no spaces): ");
        String hoten = sc.nextLine();
        sc.close();
        return hoten;
    }

    public static void test(String hoten, Stack s) {
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0){
                s.push(hoten.charAt(i));
            }
            if (i % 3 == 0) {
                s.pop();
            }
        }
    }

    //    Result
    //    Enter your full name (no spaces):
    //    nguyenthithanhhuong
    //    Result: [e, h, o]
}
