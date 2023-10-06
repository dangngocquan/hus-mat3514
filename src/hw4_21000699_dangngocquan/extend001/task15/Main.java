package hw4_21000699_dangngocquan.extend001.task15;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static class Solution {
        public void run() {
            String s = getInput();
            solve(s);
        }

        private String getInput() {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            scanner.close();
            return s;
        }

        private void solve(String s) {
            if (s.length() == 0) {
                System.out.println("");
                return;
            }

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                char prev = stack.peek();
                if (c != prev) {
                    System.out.print(prev + "" + stack.size());
                    stack.clear();
                }
                stack.push(c);
            }
            System.out.print(stack.peek() + "" + stack.size());
        }

    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
