package hw3_20001970_duongtuanson.Bai5;
import java.util.LinkedList;
import java.util.Scanner;
public class Bai22 {
    public static void main(String[] args) {
        // chèn phần tử x vào vị trí k trong danh sách liên kết
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        int n, x, k;
        System.out.print("Nhập số phần tử danh sách: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            list.add(sc.nextInt());
        }
        System.out.print("Nhập phần tử cần chèn: ");
        x = sc.nextInt();
        System.out.print("Nhập vị trí cần chèn: ");
        k = sc.nextInt();
        list.add(k, x);
        System.out.print("Các phần tử của danh sách là: " + list);
    }
}
