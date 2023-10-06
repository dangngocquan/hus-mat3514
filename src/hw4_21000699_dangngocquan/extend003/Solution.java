package hw4_21000699_dangngocquan.extend003;

import java.util.Stack;

class Solution {
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // code here
        int mid = (sizeOfStack + 1) / 2;
        Stack<Integer> s1 = new Stack<>();
        while (sizeOfStack-- > mid) s1.push(s.pop());
        s.pop();
        while (!s1.isEmpty()) s.push(s1.pop());
    }
}