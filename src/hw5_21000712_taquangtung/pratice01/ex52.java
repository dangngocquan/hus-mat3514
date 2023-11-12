package hw5_21000712_taquangtung.pratice01;

import java.util.Scanner;

/* Codelearn 52 - Giải thuật đệ quy
Nhập vào một số tự nhiện n (n ≤ 20).
Hãy phương pháp đệ quy tìm và in ra giá trị của n!.
(n! = 1 * 2 * 3 * ... * n). Quy ước 0! = 1
 */

public class ex52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập number
        int n = sc.nextInt();

        // Tính giai thừa
        long factorial = recursion(n);
        System.out.println(factorial);
    }

    static long recursion(int n) {
        if (n < 1) {
            return 1;
        } else {
            return recursion(n-1) * n;
        }
    }
}
