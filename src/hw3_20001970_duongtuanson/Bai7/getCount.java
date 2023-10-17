package Tuan3.Bai7;
import java.util.LinkedList;
import java.util.Scanner;
public class getCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        int n;
        System.out.print("Nhập số phần tử danh sách: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            list.add(sc.nextInt());
        }
        System.out.print("Độ dài của danh sách là: " + list.size());
    }
}
