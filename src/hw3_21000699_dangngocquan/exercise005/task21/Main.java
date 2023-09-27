package hw3_21000699_dangngocquan.exercise005.task21;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> listNumber = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            listNumber.add(sc.nextInt());
        }
        for (int e : listNumber) System.out.print(e + " ");
    }
}
