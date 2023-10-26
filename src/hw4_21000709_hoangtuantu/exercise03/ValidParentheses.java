package hw4_21000709_hoangtuantu.exercise03;

import hw4_21000709_hoangtuantu.exercise02.ArrayStack;
import hw4_21000709_hoangtuantu.exercise02.Stack;

import java.util.HashMap;

public class ValidParentheses {
    public static boolean valid(String s){
        Stack<Character> container = new ArrayStack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                container.push(c);
            } else if (map.containsKey(c)){
                if (container.isEmpty()){
                    return false;
                }
                if (map.get(c) == container.top()){
                    container.pop();
                }else {
                    return false;
                }
            }
        }
        return container.isEmpty();
    }

    public static void main(String[] args) {
        String[] expressions = new String[]{"(a − b) ∗ (c + d)", "(10 + 8)/((5 − 2) ∗ 17)",
                "(a + b) ∗ c − d)", "(10 − 8/((2 + 5) ∗ 17)", ")u − v) ∗ (m + n)"};
        for (String expression: expressions){
            if (valid(expression)){
                System.out.println("String " + expression + " is valid!");
            }else {
                System.out.println("String " + expression + " is not valid!");
            }
        }
    }
}
