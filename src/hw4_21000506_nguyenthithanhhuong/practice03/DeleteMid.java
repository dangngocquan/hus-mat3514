package hw4_21000506_nguyenthithanhhuong.practice03;

import hw4_21000506_nguyenthithanhhuong.ex02.ArrayStack;
import hw4_21000506_nguyenthithanhhuong.ex02.StackInterface;

public class DeleteMid {
    public static void deleteMid(StackInterface<Integer> stack, int sizeOfStack) {
        StackInterface<Integer> newStack = new ArrayStack<>();
        int j;
        if (sizeOfStack % 2 == 0) {
            j = sizeOfStack / 2 - 1;
        } else {
            j = sizeOfStack / 2;
        }
        for (int i = 0; i <= j; i++) {
            newStack.push(stack.top());
            stack.pop();
        }
        newStack.pop();
        while (!newStack.isEmpty()) {
            stack.push(newStack.top());
            newStack.pop();
        }
    }
}