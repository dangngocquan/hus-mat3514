package Tuan3.Bai8;
import java.util.LinkedList;
import java.util.Scanner;
public class getNthFromLast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        int n, k;
        System.out.print("Nhập số phần tử danh sách: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            list.add(sc.nextInt());
        }
        System.out.print("Nhập vị trí k: ");
        k = sc.nextInt();
        System.out.print("Phần tử thứ " + k + " từ cuối danh sách là: " + list.get(n - k));
    }
}
