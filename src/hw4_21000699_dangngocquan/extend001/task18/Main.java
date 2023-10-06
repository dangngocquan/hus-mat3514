package hw4_21000699_dangngocquan.extend001.task18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
            Queue<Integer> queue = new LinkedList<>();
            queue.add(2);
            queue.add(3);
            queue.add(5);
            queue.add(7);

            while (!queue.isEmpty()) {
                // Print current prime
                int number = queue.poll();
                if (number > n) break;
                System.out.print(number + " ");

                number *= 10;
                if (number >= n) continue; // Not enqueue new primes

                // Enqueue new primes
                if (isPrime(number + 1)) queue.add(number + 1);
                if (isPrime(number + 3)) queue.add(number + 3);
                if (isPrime(number + 7)) queue.add(number + 7);
                if (isPrime(number + 9)) queue.add(number + 9);
            }
        }

        private boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
