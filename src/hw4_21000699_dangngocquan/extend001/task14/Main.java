package hw4_21000699_dangngocquan.extend001.task14;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static class Solution {
        public void run() {
            int n = getInput();
            solve(n);
        }

        private int getInput() {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            scanner.close();
            return n;
        }

        private void solve(int n) {
            Stack<Integer> stack = new Stack<>();
            while (n > 0) {
                stack.push(n % 2);
                n /= 2;
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
