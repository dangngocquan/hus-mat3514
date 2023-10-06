package hw4_21000699_dangngocquan.extend001.task18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Solution {
        public void run() {
            // Get input
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int[] phoneNumbers = new int[a];
            for (int i = 0; i < a; i++) phoneNumbers[i] = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.close();

            // Solve
            solve(a, phoneNumbers, k);
        }

        private void solve(int n, int[] phoneNumbers, int k) {
            Queue<Integer> queue = new LinkedList<>();
            for (int phoneNumber : phoneNumbers) {
                if (queue.contains(phoneNumber)) continue;
                if (queue.size() == k) queue.poll();
                queue.add(phoneNumber);
            }

            while (!queue.isEmpty()) System.out.print(queue.poll() + " ");
        }


    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
