package hw4_21000117_nguyenquochieu.exercise01;

import java.util.Stack;

public class Main {
    private static Stack<Character> s = new Stack<>();
    private static String hoten = "NguyenQuocHieu";

    public static void main(String[] args) {
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0) s.push(hoten.charAt(i));
            if (i % 3 == 0) s.pop();
        }
        for (Character character : s) System.out.println(character);
        /*
        Kết quả cuối cùng là eH
         */
    }
}
