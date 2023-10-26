package hw4_21000689_nguyenxuanloi.exercises.ex2;

import java.util.Random;

public class StackTest {
    public static void main(String[] args) {
        testIntegerStack();
        testDoubleStack();
        testArrayStack();
    }

    static void testIntegerStack() {
        StackInterface<Integer> integerStack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            integerStack.push(i);
        }

        for (Integer integer: integerStack) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println(integerStack.top());

        while (!integerStack.isEmpty()) {
            System.out.print(integerStack.pop() + " ");
        }
        System.out.println();

        System.out.println(integerStack.isEmpty());
    }

    static void testDoubleStack() {
        StackInterface<Double> doubleStack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            doubleStack.push(Math.round(new Random().nextDouble(100) * 100) / 100.0);
        }

        for (Double number: doubleStack) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.println(doubleStack.top());

        while (!doubleStack.isEmpty()) {
            System.out.print(doubleStack.pop() + " ");
        }
        System.out.println();

        System.out.println(doubleStack.isEmpty());
    }

    static void testArrayStack() {
        StackInterface<Integer> integerStack = new ArrayStack<>(10);
        for (int i = 0; i < 10; i++) {
            integerStack.push(i);
        }

        for (Integer integer: integerStack) {  // Same as printing an array
            System.out.print(integer + " ");
        }
        System.out.println();

        while (!integerStack.isEmpty()) {
            System.out.print(integerStack.pop() + " ");
        }
        System.out.println();

        for (int i = 0; i <= 10; i++) { // throws IllegalStateException
            integerStack.push(i);
        }
    }
}
