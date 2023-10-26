package hw4_21000506_nguyenthithanhhuong.practice07;

import java.util.Stack;

public class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    void Push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int Pop() {
        int result = -1;
        if (!s1.isEmpty()) {
            result = s1.pop();
        }
        return result;
    }
}
