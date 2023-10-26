package hw4_21000676_damhaidang.ex1;

import java.util.Iterator;
import java.util.Stack;

public class Ex1 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        String hoten = "DamHaiDang";
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0) {
                stack.push(hoten.charAt(i));
            }
            if (i % 3 == 0) {
                stack.pop();
            }
        }
        System.out.println("Kết quả còn lại là: ");
        Iterator<Character> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
