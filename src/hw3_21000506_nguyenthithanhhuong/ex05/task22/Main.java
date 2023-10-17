package hw3_21000506_nguyenthithanhhuong.ex05.task22;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            list.add(temp);
        }

        int k = sc.nextInt();

        int x = sc.nextInt();

        sc.close();

        list.add(k, x);

        for (int element : list) {
            System.out.print(element + " ");
        }
    }
}
