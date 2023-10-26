package hw4_20001970_duongtuanson.LT7;
import java.util.Scanner;
import java.util.Stack;
public class twoQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng truy vấn: ");
        int n = sc.nextInt();
        System.out.print("Nhập truy vấn: ");
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                s1.push(x);
            } else {
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                if (!s2.isEmpty()) {
                    System.out.print(s2.pop() + " ");
                }
            }
        }
    }
}
