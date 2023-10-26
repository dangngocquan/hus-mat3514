package hw4_21000689_nguyenxuanloi.practice.ex8;

import java.util.Scanner;

public class RecentCounter {
    MyCircularQueue requests;

    public RecentCounter() {
        requests = new MyCircularQueue(10000);
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        Scanner sc = new Scanner(System.in);
        System.out.println("Start inputting:");
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            switch (input) {
                case "RecentCounter" -> recentCounter = new RecentCounter();
                case "ping" -> {
                    int t = Integer.parseInt(sc.nextLine());
                    System.out.println("Recent requests: " + recentCounter.ping(t));
                }
                default -> {
                    return;
                }
            }
        }
        sc.close();
    }

    public int ping(int t) {
        requests.enqueue(t);
        while (requests.front() < t - 3000) {
            requests.dequeue();
        }
        return requests.size();
    }
}
