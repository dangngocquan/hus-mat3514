package hw3_20000550_duongduyhieu.Bai5;

import java.util.LinkedList;
import java.util.Scanner;

public class Bai22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> ls = new LinkedList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            ls.add(sc.nextInt());
        }
        int k = sc.nextInt();
        int x = sc.nextInt();
        if (k >= 0 && k <= n) {
            ls.add(k, x);
        }
        for (int num : ls) {
            System.out.print(num + " ");
        }
    }
}
