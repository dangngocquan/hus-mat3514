package hw4_21000709_hoangtuantu.exercise05;

import hw4_21000709_hoangtuantu.exercise02.LinkedListStack;
import hw4_21000709_hoangtuantu.exercise02.Stack;


public class Palindrome {
    private static boolean notAWord(char c){
        return c < 'A' || (c > 'Z' && c < 'a') || c > 'z';
    }
    private static char middleCharacter(String string){
        int index = string.length() / 2 + 1;
        while (notAWord(string.charAt(index))){
            index++;
        }
        return string.charAt(index);
    }

    public static boolean isPalindrome(String string){
        string = string.replaceAll(" ", "").toLowerCase();
        Stack<Character> stack = new LinkedListStack<>();

        int stringLength = string.length();
        for (int i = 0; i < stringLength; i++){
            char c = string.charAt(i);
            if (notAWord(c)){
                continue;
            }
            if (stack.isEmpty()){
                stack.push(c);
            }
            else if (stack.top().equals(c)){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty() || stack.top() == middleCharacter(string);
    }
}
