package hw4_21000699_dangngocquan.extend007;

import java.util.Stack;

class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x) {
        // Your code here
        s1.push(x);
    }


    //Function to pop an element from queue by using 2 stacks.
    int Pop() {
        // Your code here
        while (!s1.isEmpty()) s2.push(s1.pop());
        int data = -1;
        if (!s2.isEmpty()) data = s2.pop();
        while (!s2.isEmpty()) s1.push(s2.pop());
        return data;
    }
}
