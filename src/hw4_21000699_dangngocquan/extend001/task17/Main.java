package hw4_21000699_dangngocquan.extend001.task17;

import java.util.*;

public class Main {
    static class Solution {
        public void run() {
            // Get input
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(scanner.nextInt());
            }
            int k = scanner.nextInt();
            scanner.close();

            // Output
            solve(n, queue, k);
        }


        private void solve(int n, Queue<Integer> queue, int k) {
            k %= n;
            while (k-- > 0) {
                queue.add(queue.poll());
            }
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
        }

    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
