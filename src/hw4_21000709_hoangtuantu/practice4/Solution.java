package hw4_21000709_hoangtuantu.practice4;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character>             stack = new Stack<>();
        HashMap<Character,Character> map   = new HashMap<>();
        map.put(')' , '(');
        map.put(']' , '[');
        map.put('}' , '{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else if (map.containsKey(c)){
                if (stack.isEmpty()){
                    return false;
                }
                if (map.get(c) == stack.peek()){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
