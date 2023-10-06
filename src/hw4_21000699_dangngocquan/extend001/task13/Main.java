package hw4_21000699_dangngocquan.extend001.task13;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static class Solution {
        public void run() {
            String string = getInput();
            solve(string);
        }

        private String getInput() {
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            scanner.close();
            return string;
        }

        private void solve(String string) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < string.length(); i++) {
                stack.push(string.charAt(i));
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
