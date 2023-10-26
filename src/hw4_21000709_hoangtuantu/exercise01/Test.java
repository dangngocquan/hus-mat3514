package hw4_21000709_hoangtuantu.exercise01;

import hw4_21000709_hoangtuantu.exercise02.ArrayStack;
import hw4_21000709_hoangtuantu.exercise02.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Character> s     = new ArrayStack<>();
        String hoten = "hoangtuantu";
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0){
                s.push(hoten.charAt(i));
            }

            if (i % 3 == 0){
                s.pop();
            }
        }
        System.out.println(s);
        /*
        Input: "hoangtuantu"
        Output: {'g', 'u'*/
    }
}
