package hw4_20001970_duongtuanson.LT1;
import java.util.Scanner;
import java.util.Stack;
public class bai14 {
    public static String convert(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.add(n % 2);
            n /= 2;
        }
        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println("Kết quả: " + convert(n));
    }
}
