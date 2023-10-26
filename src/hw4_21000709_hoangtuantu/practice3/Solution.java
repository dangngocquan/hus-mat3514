package hw4_21000709_hoangtuantu.practice3;


import java.util.Stack;

public class Solution {
    public void deleteMid(Stack<Integer> s, int sizeOfStack){
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < sizeOfStack / 2; i++){
            temp.push(s.pop());
        }
        s.pop();
        while (!temp.isEmpty()){
            s.push(temp.pop());
        }
    }
}