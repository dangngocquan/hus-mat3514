package hw3_21000699_dangngocquan.exercise005.task23;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int k = scanner.nextInt();
        scanner.close();

        list.remove(k);

        for (int e : list) {
            System.out.print(e + " ");
        }
    }
}
