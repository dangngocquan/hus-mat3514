package hw4_22001273_nguyenhoangminh.luyentap3;

import hw4_22001273_nguyenhoangminh.excercise2.LinkedListStack;

public class DeleteElement {
    public static LinkedListStack deleteElementInStack(LinkedListStack stack, int idx) {
        LinkedListStack buffer = new LinkedListStack();

        for (int i = 0; i < idx - 1; i++) {
            buffer.push(stack.pop());
        }
        stack.pop();

        for (int i = 0; i < idx - 1; i++) {
            stack.push(buffer.pop());
        }

        return stack;
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 10; ++i) {
            stack.push(i);
        }

        System.out.println(stack);
        System.out.println(deleteElementInStack(stack, 5));
    }
}
