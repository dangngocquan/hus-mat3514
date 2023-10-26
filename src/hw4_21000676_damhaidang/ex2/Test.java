package hw4_21000676_damhaidang.ex2;

import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phần tử của stack: ");
        int length = sc.nextInt();

        StackInterface arrayStack, linkedListStack;

        System.out.println("Nhập kiểu dữ liệu của các phần tử trong stack: ");
        String type = sc.next();

        switch (type.toLowerCase()) {
            case "integer":
                arrayStack = new ArrayStack<Integer>(length);
                linkedListStack = new LinkedListStack<Integer>();
                break;
            case "boolean":
                arrayStack = new ArrayStack<Boolean>(length);
                linkedListStack = new LinkedListStack<Boolean>();
                break;
            case "double":
                arrayStack = new ArrayStack<Double>(length);
                linkedListStack = new LinkedListStack<Double>();
                break;
            case "character":
                arrayStack = new ArrayStack<Character>(length);
                linkedListStack = new LinkedListStack<Character>();
                break;
            case "string":
                arrayStack = new ArrayStack<String>(length);
                linkedListStack = new LinkedListStack<String>();
                break;
            default:
                throw new IllegalArgumentException("Unknown type");
        }
        System.out.println("Test Stack implementation using array");
        testStack(arrayStack, length, sc);

        System.out.println("----------------------------------------------------------------");

        System.out.println("Test Stack implementation using linked list");
        testStack(linkedListStack, length, sc);
    }

    // Kiểm thử các phương thức được trang bị trong stack
    public static <E> void testStack(StackInterface<E> stack, int length, Scanner scanner) {
        System.out.println("Stack có trống không? " + stack.isEmpty());
        for (int i = 0; i < length; i++) {
            System.out.printf("Phần tử thứ %d: ", i + 1);
            stack.push((E)scanner.next());
        }
        System.out.println("Stack có trống không? " + stack.isEmpty());
        System.out.println("Phần tử top của stack: " + stack.top());
        printStack(stack);
        stack.pop();
        printStack(stack);
    }

    // In toàn bộ các phần tử có trong stack
    public static <E> void printStack(StackInterface<E> stack) {
        Iterator<E> iterator = stack.iterator();
        while (iterator.hasNext()) {
            E value = iterator.next();
            if (value != null) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }
}
