package hw4_20001970_duongtuanson.LT3;
import java.util.Scanner;
import java.util.Stack;
public class deleteStack {
    public static void deleteMid(Stack<Integer> stack, int sizeOfStack, int current) {
        if (stack.isEmpty() || current == sizeOfStack) {
            return;
        }
        int x = stack.pop();
        deleteMid(stack, sizeOfStack, current + 1);
        if (current != sizeOfStack / 2) {
            stack.push(x);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của stack: ");
        int sizeOfStack = scanner.nextInt();
        System.out.print("Nhập các phần tử của stack: ");
        for (int i = 0; i < sizeOfStack; i++) {
            stack.push(scanner.nextInt());
        }

        deleteMid(stack, sizeOfStack, 0);
        System.out.println(stack);
    }
}
