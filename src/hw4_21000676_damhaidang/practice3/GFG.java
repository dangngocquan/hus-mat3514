package hw4_21000676_damhaidang.practice3;

//{ Driver Code Starts
//Initial template for Java

import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int sizeOfStack = sc.nextInt();
            Stack<Integer> myStack = new Stack<>();

            //adding elements to the stack
            for (int i = 0; i < sizeOfStack; i++) {
                int x = sc.nextInt();
                myStack.push(x);

            }
            Solution obj = new Solution();
            obj.deleteMid(myStack, sizeOfStack);

            while (!myStack.isEmpty()) {
                System.out.print(myStack.peek() + " ");
                myStack.pop();
            }
            System.out.println();
        }


    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // code here
        int mid = sizeOfStack / 2;
        Stack<Integer> temp = new Stack<>();
        int count = 0;

        while (!s.isEmpty() && count < mid) {
            temp.push(s.pop());
            count++;
        }
        s.pop();

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }
}

