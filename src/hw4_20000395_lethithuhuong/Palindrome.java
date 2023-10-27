package hw4_20000395_lethithuhuong;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String line = reader.readLine();


            if (line.toLowerCase().equals("quit")) {
                break;
            }

            Stack<Character> stack = new Stack<Character>();

            Queue<Character> queue = new LinkedList<Character>();

            for (int i = 0; i < line.length(); i++) {
                stack.push(line.charAt(i));
            }

            for (int i = 0; i < line.length(); i++) {
                queue.add(line.charAt(i));
            }

            boolean isPalindrome=true;
            while (!queue.isEmpty()) {
                if (queue.remove().equals(stack.pop())) {
                    continue;
                } else {
                    isPalindrome=false;
                    break;
                }
            }
            if (!isPalindrome) {
                System.out.println("Not a Palindrome");
            } else {
                System.out.println("Palindrome");
            }

        }     
    }
}