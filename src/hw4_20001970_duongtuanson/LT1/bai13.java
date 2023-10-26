package hw4_20001970_duongtuanson.LT1;
import java.util.Scanner;
import java.util.Stack;
public class bai13 {
    public static String reverse(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
        }
        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        System.out.println("Kết quả: " + reverse(s));
    }
}
