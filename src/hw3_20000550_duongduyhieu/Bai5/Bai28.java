package hw3_20000550_duongduyhieu.Bai5;

import java.util.LinkedList;
import java.util.Scanner;

public class Bai28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i ++) {
            list.add(sc.nextInt());
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a >= 0 && a <= n ) {
            list.add(a, b);
        }

        for (int i : list){
            System.out.print(i + " ");
        }
    }
}
